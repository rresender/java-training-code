package com.rresende.hackerrank;

final class BinaryTree {
    
    final static class Node {
        
        final int data;
        Node left, right;
        
        public Node(final int key) {
            this.data = key;
            this.right = this.left = null;
        }
    }

    private Node root;
    
    final void createNode(final int parent[], final int i, final Node created[]) {

        if (created[i] != null)
            return;

        created[i] = new Node(i);

        if (parent[i] == -1) {
            root = created[i];
            return;
        }

        if (created[parent[i]] == null)
            createNode(parent, parent[i], created);

        final Node p = created[parent[i]];

        if (p.left == null)
            p.left = created[i];
        else
            p.right = created[i];
    }

    final Node createTree(final int parent[], final int n) {
        final Node[] created = new Node[n];
        for (int i = 0; i < n; i++)
            created[i] = null;

        for (int i = 0; i < n; i++)
            createNode(parent, i, created);

        return root;
    }

}
