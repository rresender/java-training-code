package com.rresende.hackerrank;
import java.util.LinkedList;
import java.util.Queue;



public class Huffman {
	
	static class Node {
		public  int frequency;
		public  char data;
		public  Node left, right;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node n1 = new Node();
		n1.frequency = 5;
		n1.data ='\0';
		Node n2 = new Node();
		n2.frequency = 3;
		n2.data ='\0';
		Node n3 = new Node();
		n3.frequency = 2;
		n3.data ='A';
		Node n4 = new Node();
		n4.frequency = 1;
		n4.data ='B';
		Node n5 = new Node();
		n5.frequency = 1;
		n5.data ='C';
		
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
		
		new Huffman().decode("1001011", n1);

	}
	
	void decode(String S, Node root) {

		char[] charArray = S.toCharArray();
	
		StringBuilder decoded = new StringBuilder();
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		for (char c : charArray) {
			if (c == '1') {		
				if (queue.isEmpty()) {
					queue.add(root);
				}
				Node node = queue.poll();
				if (node.right != null) {
					if (node.right.data != '\0') {
						decoded.append(node.right.data);
						queue.add(root);
					} else {
						queue.add(node.right);
					}
				}
			} else {
				if (queue.isEmpty()) {
					queue.add(root);
				}
				Node node = queue.poll();
				if (node.right != null) {
					if (node.left.data != '\0') {
						decoded.append(node.left.data);
						queue.add(root);
					} else {
						queue.add(node.left);
					}
				}
			}
		}
		
		System.out.println(decoded.toString());
    }

}
