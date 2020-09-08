package com.resende.codesignal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSummary {

	static class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}

	static int[] levelOrder(Tree<Integer> t) {

		List<Integer> list = new ArrayList<>();
		Queue<Tree<Integer>> q = new LinkedList<>();
		q.add(t);
		while (!q.isEmpty()) {
			Tree<Integer> n = q.poll();
			list.add(n.value);
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}

		list.forEach(e -> {
			System.out.print(e + " ");
		});

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	static void printPreOrder(Tree<Integer> node) {
		if (node == null) {
			return;
		}

		System.out.print(node.value + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	static void printInOrder(Tree<Integer> node) {
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.value + " ");
		printInOrder(node.right);
	}

	static void printPostOrder(Tree<Integer> node) {
		if (node == null) {
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.value + " ");
	}

	static int height(Tree<Integer> root) {
		if (root == null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;
	}

	static Tree<Integer> insert(Tree<Integer> root, int value) {

		if (root == null) {
			root = new Tree<Integer>(value);
			return root;
		}

		Queue<Tree<Integer>> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			root = q.peek();
			q.remove();

			if (root.left == null) {
				root.left = new Tree<Integer>(value);
				break;
			} else {
				q.add(root.left);
			}

			if (root.right == null) {
				root.right = new Tree<Integer>(value);
				break;
			} else {
				q.add(root.right);
			}
		}
		return root;
	}

	static Tree<Integer> insertRec(Tree<Integer> root, int value) {

		if (root == null) {
			return new Tree<Integer>(value);
		}

		if (value < root.value) {
			root.left = insertRec(root.left, value);
		} else if (value > root.value) {
			root.right = insertRec(root.right, value);
		} else {
			return root;
		}

		return root;
	}

	static boolean isBinarySearchTree(Tree<Integer> root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static boolean isBST(Tree<Integer> root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.value < min || root.value > max) {
			return false;
		}
		return isBST(root.left, min, root.value - 1) && isBST(root.right, root.value + 1, max);
	}

	static boolean search(Tree<Integer> root, int value) {
		if (root == null) {
			return false;
		}

		if (value == root.value) {
			return true;
		}

		return value < root.value ? search(root.left, value) : search(root.right, value);
	}

	static Tree<Integer> find(Tree<Integer> root, int value) {
		if (root == null) {
			return null;
		}
		if (root.value == value) {
			return root;
		}
		Tree<Integer> node = find(root.left, value);
		return node != null ? node : find(root.right, value);
	}

	static Tree<Integer> delete(Tree<Integer> root, int value) {

		if (root == null) {
			return null;
		}

		if (value == root.value) {
			if (root.left == null && root.right == null) {
				return null;
			}

			if (root.right == null) {
				return root.left;
			}

			if (root.left == null) {
				return root.right;
			}

			int smallestValue = findSmallestValue(root.right);
			root.value = smallestValue;
			root.right = delete(root.right, smallestValue);
			return root;
		}

		if (value < root.value) {
			root.left = delete(root.left, value);
			return root;
		}

		root.right = delete(root.right, value);
		return root;
	}

	static List<Integer> getNodeAt(Tree<Integer> root, int dest, int distance) {
		List<Integer> result = new ArrayList<>();
		Queue<Tree<Integer>> q = new LinkedList<>();
		q.add(root);
		int counter = 0;
		boolean found = false;
		while (!q.isEmpty()) {

			Tree<Integer> node = q.poll();

			if (counter == distance) {
				counter = 0;
				result.add(node.value);
			}

			if (node.left != null) {
				if (!found && node.left.value == dest) {
					found = true;
				}
				q.add(node.left);
			}

			if (node.right != null) {
				if (!found && node.right.value == dest) {
					found = true;
				}
				q.add(node.right);
			}

			if (found) {
				counter++;
			}
		}
		return result;
	}

	static void printdistanceNodeDown(Tree<Integer> node, int d) {
		if (node == null || d < 0)
			return;

		if (d == 0) {
			System.out.print(node.value);
			System.out.println("");
			return;
		}

		printdistanceNodeDown(node.left, d - 1);
		printdistanceNodeDown(node.right, d - 1);
	}

	static int printdistanceNode(Tree<Integer> node, Tree<Integer> target, int k) {

		if (node == null)
			return -1;

		if (node == target) {
			printdistanceNodeDown(node, k);
			return 0;
		}

		int dl = printdistanceNode(node.left, target, k);

		if (dl != -1) {

			if (dl + 1 == k) {
				System.out.print(node.value);
				System.out.println("");
			}

			else
				printdistanceNodeDown(node.right, k - dl - 2);
			return 1 + dl;
		}

		int dr = printdistanceNode(node.right, target, k);
		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.print(node.value);
				System.out.println("");
			} else {
				printdistanceNodeDown(node.left, k - dr - 2);
			}
			return 1 + dr;
		}
		
		return -1;
	}

	static int findSmallestValue(Tree<Integer> root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	public static void main(String[] args) {

//		tree.root = new Node(1); 
//        tree.root.left = new Node(2); 
//        tree.root.right = new Node(3); 

//        tree.root.left.left = new Node(4); 
//        tree.root.left.right = new Node(5); 

//		Tree<Integer> n1 = new Tree<Integer>(1); 
//        Tree<Integer> n2 = new Tree<Integer>(2);
//        Tree<Integer> n3 = new Tree<Integer>(3);
//        Tree<Integer> n4 = new Tree<Integer>(4);
//        Tree<Integer> n5 = new Tree<Integer>(5);
//        
//		n1.left = n2; 
//		n1.right = n3; 
//		
//		n2.left = n4; 
//		n2.right = n5;

//		Tree<Integer> root = insert(null, 1);
//		root = insertRec(root, 2);
//		root = insertRec(root, 3);
//		root = insertRec(root, 4);
//		root = insertRec(root, 5);
//		root = insertRec(root, 6);

//		insert(root, 2);
//		insert(root, 3);
//		insert(root, 4);
//		insert(root, 5);
//		insert(root, 6);

//		System.out.println(isBinarySearchTree(root));

//		System.out.println(height(root));
//		levelOrder(root);
//		System.out.println();
//		printPreOrder(root);
//		System.out.println();
//		printInOrder(root);
//		System.out.println();
//		printPostOrder(root);
//		levelOrder(root);
//		System.out.println(search(root, 6));
//		root = delete(root, 3);
//		levelOrder(root);
//		System.out.println(search(root, 3));

		Tree<Integer> n1 = new Tree<Integer>(3);
		Tree<Integer> n2 = new Tree<Integer>(5);
		Tree<Integer> n3 = new Tree<Integer>(1);
		Tree<Integer> n4 = new Tree<Integer>(6);
		Tree<Integer> n5 = new Tree<Integer>(2);
		Tree<Integer> n6 = new Tree<Integer>(7);
		Tree<Integer> n7 = new Tree<Integer>(4);
		Tree<Integer> n8 = new Tree<Integer>(0);
		Tree<Integer> n9 = new Tree<Integer>(8);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n5.left = n6;
		n5.right = n7;

		n3.left = n8;
		n3.right = n9;

		printdistanceNode(n1, n4, 4);

	}
	/*
	 * Preorder traversal of binary tree is 1 2 4 5 3 Inorder traversal of binary
	 * tree is 4 2 5 1 3 Postorder traversal of binary tree is 4 5 2 3 1
	 */
}
