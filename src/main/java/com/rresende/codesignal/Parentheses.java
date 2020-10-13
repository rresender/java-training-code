package com.rresende.codesignal;

import java.util.Stack;

public class Parentheses {
	
	static int longestValidParenteses(String s) {
		int max  = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					max = Math.max(max, i - stack.peek());
				}
			}
		}
		return max;
	}
	
	static int countBalancedParenteses(String s) {
		int count  = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
					count++;
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(countBalancedParenteses("(()"));
		System.out.println(countBalancedParenteses("((()))()"));
		System.out.println(countBalancedParenteses(")(()"));
		
	}

}
