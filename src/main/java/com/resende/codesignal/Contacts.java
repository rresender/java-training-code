package com.resende.codesignal;

import java.util.Arrays;
import java.util.Scanner;

public class Contacts {

	static class Node {
		int size;
		boolean endOfWord;
		Node[] children = new Node[26];
		
		@Override
		public String toString() {
			return "Node [size=" + size + ", endOfWord=" + endOfWord + ", children="
					+ Arrays.toString(children) + "]";
		}
	}

	static Node root;

	static void add(String s) {

		Node node = root;

		for (char c : s.toCharArray()) {
			int i = Character.getNumericValue(c) - Character.getNumericValue('a');

			if (node.children[i] == null) {
				node.children[i] = new Node();
			}
			node = node.children[i];
			node.size++;
		}
		node.endOfWord = true;
	}

//	static int find(String s) {
//
//		Node node = root;
//
//		for (char c : s.toCharArray()) {
//			int i = c - 'a';
//
//			if (node.children[i] == null) {
//				return 0;
//			}
//			node = node.children[i];
//		}
//
//		return node.size;
//	}
	
	static int find(String s) {

		Node node = root;

		for (char c : s.toCharArray()) {
			int i = Character.getNumericValue(c) - Character.getNumericValue('a');
			if (node.children[i] == null) {
				return 0;
			}
			node = node.children[i];
		}

		for (int i = 0; i < node.children.length; i++) {
			if (node.children[i] != null) {
				char c=(char)i;  
				System.out.println(c);
			}
		}
		
		return node.size;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		root = new Node();
		
		for (int nItr = 0; nItr < n; nItr++) {
			String[] opContact = scanner.nextLine().split(" ");

			String op = opContact[0];
			String contact = opContact[1];
		
			switch (op) {
			case "add":
				add(contact);
				break;
			case "find":
				System.out.println(" "+find(contact));
				break;
			default:
				break;
			}
		}

		scanner.close();
	}

}
