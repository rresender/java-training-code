package com.rresende.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwapNodes {

    static class Node {
        Integer data;
        Node left;
        Node right;

        public Node() {

        }

        public Node(Integer data) {
            this.data = data;
        }
    }

    static Node root;

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (final Scanner in = new Scanner(System.in)) {

            int n = in.nextInt();

            insert(1);
            for (int i = 0; i < n; i++) {
                insert(in.nextInt());
                insert(in.nextInt());
            }

            int q = in.nextInt();

            int[] swap = new int[q];
            for (int i = 0; i < q; i++) {
                swap[i] = in.nextInt();
            }

            for (int i = 0; i < swap.length; i++) {
                swapN(swap[i]);
                inOrder(root);
                System.out.println();
            }
        }
    }

    static void swap(int swap) {
        swap(root, 1, swap);
    }

    static void swap(Node node, int clevel, int rlevel) {
        if (node == null) {
            return;
        } else {
            if (clevel % rlevel == 0) {
                Node left = node.left;
                node.left = node.right;
                node.right = left;
            }
            if (node.left != null) {
                swap(node.left, clevel + 1, rlevel);
            }
            if (node.right != null) {
                swap(node.right, clevel + 1, rlevel);
            }
        }
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(((root.data != null && root.data != -1) ? root.data + " " : ""));
        inOrder(root.right);

    }

    static void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Queue<Node> nodesToProcess = new LinkedList<>();
        nodesToProcess.add(root);

        while (true) {
            Node actualNode = nodesToProcess.poll();

            if (actualNode != null && actualNode.left == null) {
                if (actualNode.data != -1) {
                    actualNode.left = new Node(data);
                    return;
                }
            }

            if (actualNode != null && actualNode.right == null) {
                if (actualNode.data != -1) {
                    actualNode.right = new Node(data);
                    return;
                }
            }

            if (actualNode != null) {
                nodesToProcess.add(actualNode.left);
                nodesToProcess.add(actualNode.right);
            }
        }
    }

    static void swapN(int rlevel) {
        if (root == null) {
            throw new NullPointerException("The root cannot be null.");
        }

        Queue<Node> queue = new java.util.LinkedList<>();
        Queue<Node> queueNext = new java.util.LinkedList<>();
        queue.add(root);
        int clevel = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (clevel % rlevel == 0) {
                Node left = node.left;
                node.left = node.right;
                node.right = left;
            }

            if (node.left != null)
                queueNext.add(node.left);
            if (node.right != null)
                queueNext.add(node.right);
            if (queue.isEmpty()) {
                queue = queueNext;
                queueNext = new java.util.LinkedList<>();
                clevel++;
            }
        }
    }
}
