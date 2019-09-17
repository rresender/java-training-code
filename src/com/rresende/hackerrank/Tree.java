package com.rresende.hackerrank;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node() {

		}

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right
					+ "]";
		}
		
		
	}

	public static void main(String[] args) {

		Node n1 = new Node();
		n1.data = 1;
		Node n2 = new Node();
		n2.data = 2;
		Node n3 = new Node();
		n3.data = 3;
		Node n4 = new Node();
		n4.data = 4;
		Node n5 = new Node();
		n5.data = 5;
		Node n6 = new Node();
		n6.data = 6;
		Node n7 = new Node();
		n7.data = 7;
		Node n8 = new Node();
		n8.data = 8;
		Node n9 = new Node();
		n9.data = 9;
		Node n10 = new Node();
		n10.data = 10;
		Node n11 = new Node();
		n11.data = 11;
		Node n12 = new Node();
		n12.data = 12;
		Node n13 = new Node();
		n13.data = 13;
		Node n14 = new Node();
		n14.data = 14;
		Node n18 = new Node();
		n18.data = 18;
		
		n13.left = n3;
		n13.right = n14;
		
		n3.left = n1;
		n3.right = n4;
		
		n14.right = n18;
		
		n1.right = n2;
		
		n4.right = n12;
				
		// tree.preOrder(n3);
		// System.out.println();
		// tree.postOrder(n3);
		// System.out.println();
		// tree.inOrder(n3);
		// System.out.println();
		// System.out.println(height(n3));

		// tree.top_view(n3);
//		tree.level_order(n4);
//		tree.insert(n4, 6);
//		System.out.println();
//		tree.level_order(n4);
//		System.out.println();
//		tree.insert(n4, 10);
//		System.out.println();
//		tree.level_order(n4);
		Tree tree = new Tree();
//		tree.level_order(n13);
		
		int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 16, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		Node node = createTree(a, 0, a.length-1);
	
		System.out.println(tree.checkBST(node));
	}
	
	 static Node createTree(int[] A, int l, int h) {
		  if (l > h)
		    return null;
		  if(l==h){
		    return new Node(A[l]);
		  }
			
		  int mid = (l + h) / 2;
		  Node root = new Node(A[mid]);
		  root.left = createTree(A, l, mid - 1); // - 1
		  root.right = createTree(A, mid + 1, h);// - 2
		  return root;
	 }
	
	boolean checkBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	 
	 boolean isBST(Node node, int minKey, int maxKey) {
	    if(node == null) return true;
	    if(node.data <= minKey || node.data >= maxKey) return false;
	    return isBST(node.left, minKey, node.data) && isBST(node.right, node.data, maxKey);
	}

	void preOrder(Node root) {

		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	void postOrder(Node root) {

		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

	void top_view(Node root) {
		if (root == null) {
			return;
		}

		Stack<Integer> sl = new Stack<>();
		Node left = root.left;
		while (left != null) {
			sl.push(left.data);
			left = left.left;
		}

		Queue<Integer> qr = new java.util.LinkedList<>();
		qr.offer(root.data);

		Node right = root.right;
		while (right != null) {
			qr.offer(right.data);
			right = right.right;
		}

		while (!sl.isEmpty()) {
			System.out.print(sl.pop() + " ");
		}
		while (!qr.isEmpty()) {
			System.out.print(qr.poll() + " ");
		}

	}

	void level_order(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.printf("%d ", tempNode.data);
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
	}

	Node insert(Node root, int value) {

		if (root == null) {
			root = new Node();
			root.data = value;
			return root;
		} else {
			if (value <= root.data) {
				root.left = insert(root.left, value);
			} else {
				root.right = insert(root.right, value);
			}
		}

		return root;
	}
	
	public void breadthFirstSearch(Queue<Node> queue) {
		if (queue.isEmpty()) 
		  return;

		Node node = (Node) queue.poll();

		System.out.println(node + " ");

		if (node.right != null) 
		  queue.offer(node.right);

		if (node.left != null) 
		  queue.offer(node.left);

		breadthFirstSearch(queue);
	}



	int height(Node root) {
		if (root == null) {
			return -1;
		}

		int left = height(root.left) + 1;
		int right = height(root.right) + 1;

		if (left > right) {
			return left;
		}
		return right;
	}

	Node lca(Node root, int v1, int v2) {

        if (root == null)
            return null;
      
        if (root.data == v1 || root.data == v2)
            return root;
 
        Node left_lca = lca(root.left, v1, v2);
        Node right_lca = lca(root.right, v1, v2);
 
        if (left_lca != null && right_lca != null)
            return root;
 
        return (left_lca != null) ? left_lca : right_lca;
		
	}
}
