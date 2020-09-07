package com.resende.codesignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Contacts2 {

	static class Node {
		int size;
		boolean endOfWord;
		Map<Character, Node> children = new HashMap<>();
	}

	static Node root;

	static void add(String s) {
		Node node = root;
		int i;
		int len = s.length();
		for (i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (!node.children.containsKey(c)) {
				node.children.putIfAbsent(c, new Node());
			}
			node = node.children.get(c);
			node.size++;
		}
		node.endOfWord = true;
	}

	static void displayContactsUtil(Node curNode, String prefix) {

		if (curNode.endOfWord) {
			System.out.println(prefix);
		}

		for (char i = 'a'; i <= 'z'; i++) {
			Node nextNode = curNode.children.get(i);
			if (nextNode != null) {
				displayContactsUtil(nextNode, prefix + i);
			}
		}
	}

	static void displayContacts(String str) {
		Node prevNode = root;

		String prefix = "";
		int len = str.length();

		int i;
		for (i = 0; i < len; i++) {
			prefix += str.charAt(i);

			char lastChar = prefix.charAt(i);

			Node curNode = prevNode.children.get(lastChar);

			if (curNode == null) {
				System.out.println("\nNo Results Found for " + prefix + "");
				i++;
				break;
			}

			System.out.println("\nSuggestions based on " + prefix + " are");

			displayContactsUtil(curNode, prefix);

			prevNode = curNode;
		}

		for (; i < len; i++) {
			prefix += str.charAt(i);
			System.out.println("\nNo Results Found for " + prefix + "");
		}
	}

	static List<String> find(String s) {
		Node node = root;
		List<String> words = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!node.children.containsKey(c)) {
				return words;
			}
			node = node.children.get(c);
		}
		find(node, s, words);
		return words;
	}

	static void find(Node node, String prefix, List<String> words) {
		if (node.endOfWord) {
			words.add(prefix);
		}
		for (char c: node.children.keySet()) {
			if (node.children.get(c) != null) {
				find(node.children.get(c), prefix + c, words);
			}
		}
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
				System.out.println(find(contact));
				break;
			default:
				break;
			}
		}

		scanner.close();
	}

}
