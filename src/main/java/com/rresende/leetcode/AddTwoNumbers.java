package com.rresende.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class AddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	ListNode insertTail(ListNode head, int data) {
		ListNode node = new ListNode(data);
		if (head == null) {
			return node;
		}
		ListNode aux = head;
		while (aux.next != null) {
			aux = aux.next;
		}
		aux.next = node;
		return head;
	}

	ListNode getNode(final ListNode p) {
		return p == null ? null : p.next;
	}

	int getVal(final ListNode n) {
		return n == null ? 0 : n.val;
	}

	public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {

		ListNode head = null;
		ListNode p = l1;
		ListNode q = l2;

		int carry = 0;

		while (p != null || q != null) {

			final int x = getVal(p);
			final int y = getVal(q);

			final int sum = x + y + carry;

			carry = sum / 10;

			final int val = sum % 10;

			head = insertTail(head, val);

			p = getNode(p);
			q = getNode(q);
		}

		if (carry == 1) {
			head = insertTail(head, 1);
		}

		return head;
	}

	String join(final ListNode head) {
		if (head == null) {
			return "";
		}
		return String.format("%s%s", join(head.next), head.val);
	}

	void reverse(String[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			String temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
	}

	ListNode buildList(int val) {
		ListNode head = null;
		final String[] numbers = Long.toString(val).split("");
		reverse(numbers);
		for (final String s : numbers) {
			head = insertTail(head, Integer.valueOf(s));
		}
		return head;
	}

	@Test
	public void addTwoNumbers() {

		ListNode l1 = buildList(342);
		ListNode l2 = buildList(465);

		ListNode lf = addTwoNumbers(l1, l2);

		assertThat(join(lf), is("807"));

		l1 = buildList(81);
		l2 = buildList(0);

		lf = addTwoNumbers(l1, l2);

		assertThat(join(lf), is("81"));

		l1 = buildList(5);
		l2 = buildList(5);

		lf = addTwoNumbers(l1, l2);

		assertThat(join(lf), is("10"));

	}

}
