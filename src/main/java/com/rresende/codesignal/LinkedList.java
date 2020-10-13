package com.rresende.codesignal;

public class LinkedList<T> {

	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("rawtypes")
			Node other = (Node) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			return true;
		}

	}

	private Node<T> head;
	private int size;

	public int size() {
		return size;
	}

	public T getLast() {
		if (isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		return head.data;
	}

	public T getFirst() {
		if (isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		Node<T> tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		return tmp != null ? tmp.data : null;
	}

	void print() {
		print(head);
	}

	void print(Node<T> node) {
		if (node == null) {
			System.out.println();
			return;
		}
//		System.out.print(node.data + " ");
		print(node.next);
		System.out.print(node.data + " ");
	}

	void reverse() {

		if (isEmpty()) {
			return;
		}

		Node<T> prev = null;

		while (head.next != null) {
			Node<T> temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}

		head.next = prev;
	}

	void reverseRec() {
		head = reverseRec(head);
	}

	Node<T> reverseRec(Node<T> head) {

		if (isEmpty() || head.next == null) {
			return head;
		}

		Node<T> temp = reverseRec(head.next);

		head.next.next = head;
		head.next = null;

		return temp;
	}

	void delete(Node<T> toDelete) {

		if (isEmpty() || toDelete == null) {
			return;
		}

		if (toDelete == head) {
			head = head.next;
		}

		Node<T> next = toDelete.next;

		if (next != null) {
			toDelete.data = next.data;
			toDelete.next = next.next;
		}
		size--;
	}

	void add(T data) {
		if (isEmpty()) {
			head = new Node<T>(data, null);
		} else {
			head = new Node<T>(data, head);
		}
		size++;
	}

	boolean isEmpty() {
		return head == null;
	}

	void addTail(T data) {
		if (isEmpty()) {
			head = new Node<T>(data, null);
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<T>(data, null);
		}
		size++;
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(9);
		l1.add(8);
		l1.print();
		
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(2);
		l2.print();
		
		Node<Integer> tmp1 = l1.head;
		Node<Integer> tmp2 = l2.head;
		
		int carry = 0;		
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		while (tmp1 != null || tmp2 != null) {
			
			Integer v1 = 0;
			if (tmp1 != null) {
				v1 = tmp1.data;
				tmp1 = tmp1.next;
			}
			Integer v2 = 0;
			if (tmp2 != null) {
				v2 = tmp2.data;
				tmp2 = tmp2.next;
			}
			
			int sum = v1 + v2 + carry;
			
			if (sum >= 10) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			
			l3.addTail(sum);
		}
		
		if (carry == 1) {
			l3.addTail(1);
		}
		
		l3.print();
	}
}
