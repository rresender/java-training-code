package com.rresende.hackerrank;


public class DoblyLinkedList {

	static class Node {
		int data;
		Node next;
		Node prev;
		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + (next != null ? next.data : next) + ", prev=" + (prev != null ? prev.data : prev)
					+ "]";
		}
		
	}

	public static void main(String[] args) {
		
		Node headA = new Node();
		headA.data = 1;
		
		Node n1a = new Node();
		n1a.data = 3;
		
		Node n2a = new Node();
		n2a.data = 4;
		
		Node n3a = new Node();
		n3a.data = 5;
		
		Node n4a = new Node();
		n4a.data = 6;
		
		headA.next = n1a;
		headA.prev = null;
		
		n1a.next = n2a;
		n1a.prev = headA;
		
		n2a.next = n3a;
		n2a.prev = n1a;
		
		n3a.next = n4a;
		n3a.prev = n2a;
		
		n4a.next = null;
		n4a.prev = n3a;
		
		DoblyLinkedList ll = new DoblyLinkedList();
		ll.print(headA);
		System.out.println();
//		headA = ll.sortedInsert(headA, -10);
//		ll.print(headA);
//		System.out.println();
		
		headA = ll.reverse(headA);
		ll.print(headA);
	}
	
	void print(Node head) {
		if (head == null) {
			return;
		}
		System.out.println(head.data);
		print(head.next);
	}
	
	Node sortedInsert(Node head, int data) {
		
		Node node = new Node();
		node.data = data;
		
		if (head == null) {
			return head;
		}
		
		Node aux = head;
		boolean inserted = false;
		while (aux.next != null) {
			if (data >= aux.data && data <= aux.next.data) {
				Node next = aux.next;
				aux.next = node;
				node.prev = aux;
				node.next = next;
				node.next.prev = node;
				inserted = true;
				break;
			}
			aux = aux.next;
		}
		
		if (!inserted) {
			if (data < head.data){
				node.next = head;
				head.prev = node;
				head = node;
			} else {
				aux.next = node;
				node.prev = aux;
			}
		}
		
		return head;
	}
	
	Node reverse(Node head) {
		
		if (head == null) {
			return head;
		}
		
		while (head.next != null) {
			Node old = head.next;
			head.next = head.prev;
			head.prev = head;
			head = old;
		}
		
		head.next = head.prev;
		head.prev = null;
			
		return head;
		
	}
}
