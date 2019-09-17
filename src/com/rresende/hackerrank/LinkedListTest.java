package com.rresende.hackerrank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class LinkedListTest {

	static class Node {
		int data;
		Node next;
		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}

	public static void main(String[] args) {
		
		Node headA = new Node();
		headA.data = 1;
		
		Node n1a = new Node();
		n1a.data = 2;
		
		Node n2a = new Node();
		n2a.data = 3;
		
		Node n3a = new Node();
		n3a.data = 4;
		
		Node n4a = new Node();
		n4a.data = 5;
		
		headA.next = n1a;
		n1a.next = n2a;
		n2a.next = n3a;
		n3a.next = n4a;
		
		Node headB = new Node();
		headB.data = 1;
		
		Node n1b = new Node();
		n1b.data = 1;
		
		Node n2b = new Node();
		n2b.data = 1;
		
		Node n3b = new Node();
		n3b.data = 4;
		
		Node n4b = new Node();
		n4b.data = 5;
		
		headB.next = n1b;
		n1b.next = n2b;
		n2b.next = n3b;
		n3b.next = n4b;
		
		
		
		LinkedListTest ll = new LinkedListTest();
		ll.print(headB);
		System.out.println();
//		ll.reversePrint(head);
		
//		System.out.println();
//		head = ll.insertTail(head, 6);
//		ll.print(head);
//		
//		System.out.println();
//		head = ll.insert(head, 0);
//		ll.print(head);
		
//		System.out.println();
//		head = ll.insertNth(head, 666, 4);
//		ll.print(head);
//		
//		headA = ll.delete(headA, 4);
//		ll.print(headA);
//		headA = ll.reverse(headA);
		
//		System.out.println(ll.compareLists(headA, headB));
		
//		Node merged = ll.mergeLists(headA, headB);
//		ll.print(merged);
		
//		System.out.println(ll.getNode(headA, 2));
		
//		headA = ll.removeDuplicates(headB);
//		ll.print(headB);
		
//		System.out.println(ll.hasCycle(headA));
		
		System.out.println(ll.findMergeNode(headA, headB));
		
	}

	void print(Node head) {
		if (head == null) {
			return;
		}
		System.out.println(head.data);
		print(head.next);
	}
	
	Node insertTail(Node head, int data) {
		
		Node node = new Node();
		node.data = data;
		
		if (head == null) {
			return node;
		}
		
		Node aux = head;
		
		while (aux.next != null) {
			aux = aux.next;
		}
		
		aux.next = node;
		
		return head;
	}
	
	Node insert(Node head, int data) {
		
		Node node = new Node();
		node.data = data;
		
		if (head == null) {
			return node;
		}
		
		node.next = head;
		
		return node;
	}
	
	Node insertNth(Node head, int data, int position) {
		Node node = new Node();
		node.data = data;
		
		if (head == null) {
			return node;
		}
		
		if (position == 0) {
			node.next = head;
			return node;
		}
		
		int count = 1;
		Node aux = head;
		while (aux.next != null) {
			if (count == position) {
				Node temp = aux.next;
				aux.next = node;
				aux.next.next = temp;
				break;
			}
			count++;
			aux = aux.next;
		}
		
		return head;
		
	}
	
	Node delete(Node head, int position) {
		
		if (head == null) {
			return head;
		}
		
		if (position == 0) {
			head = head.next;
			return head;
		}
		
		int count = 1;
		Node aux = head;
		while (aux.next != null) {
			if (count == position) {
				Node temp = aux.next.next;
				aux.next = temp;
				break;
			}
			count++;
			aux = aux.next;
		}
		
		return head;
		
	}
	
	void reversePrint(Node head) {
		if (head == null) {
			return;
		}
		reversePrint(head.next);
		System.out.println(head.data);
	}
	
	Node reverse(Node head) {
		
		if (head == null) {
			return head;
		}
		
		Node prev = null;
		while (head.next != null) {
			Node temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		head.next = prev;
		return head;
	}
	
	int compareLists(Node headA, Node headB) {
		
		
		while (headA.next != null && headB.next != null) {
			if (headA.data != headB.data) {
				return 0;
			}
			
			headA = headA.next;
			headB = headB.next;
		}
		
		if (headA.data != headB.data) {
			return 0;
		}
		
		if (headA.next != null || headB.next != null) {
			return 0;
		}
		
		return 1;
	}
	
	Node mergeLists(Node headA, Node headB) {
		
		if (headA == null && headB == null) {
	    	return null;
	    }
		
	    if (headA == null) {
	    	return headB;
	    }
	    
	    if (headB == null) {
	    	return headA;
	    }
	    
	    SortedSet<Integer> set = new TreeSet<>();
	    
	    while (headA.next != null) {
	    	set.add(headA.data);
	    	headA = headA.next;
	    }
	    set.add(headA.data);
	    
	    while (headB.next != null) {
	    	set.add(headB.data);
    		headB = headB.next;
    	}
	    set.add(headB.data);
	    
	    Node head = new Node();
	    head.data = set.first();
	    Boolean first = true;
	    for (Integer data : set) {
	    	if (first) {
	    		first = false;
	    		continue;
	    	}
	    	Node node = new Node();
			node.data = data;
			
			Node aux = head;	
			while (aux.next != null) {
				aux = aux.next;
			}
			
			aux.next = node;
		}
	    return head;
	}
	
	int getNode(Node head, int n) {
		
		if (head == null) {
			return 0;
		}
		
		Node aux = head;
		int size = 0;
		while (aux.next != null) {
			size++;
			aux = aux.next;
		}
		
		int count = 0;
		while (head.next != null) {
			if ((size-count) == n) {
				return head.data;
			}
			count++;
			head = head.next;
		}
		
		return head.data;
	}
	
	Node removeDuplicates(Node head) {
		
		if (head == null) {
			return null;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> delete = new ArrayList<>();
		
		int pos = 0;
		Node aux = head;
		while (aux.next != null) {
			Integer data = map.get(aux.data);
			if (data == null) {
				map.put(aux.data, pos);
			} else {
				delete.add(pos);
			}
			pos++;
			aux = aux.next;
		}
		
		Integer data = map.get(aux.data);
		if (data == null) {
			map.put(aux.data, pos);
		} else {
			delete.add(pos);
		}
		
		for (int i = delete.size()-1; i >= 0; i--) {
			int count = 1;
			aux = head;
			while (aux.next != null) {
				if (count == delete.get(i)) {
					Node temp = aux.next.next;
					aux.next = temp;
					break;
				}
				count++;
				aux = aux.next;
			}
		}
		
		return head;
	}
	
	boolean hasCycle(Node head) {
		
		if (head == null) {
			return false;
		}
		
		Set<Node> visited = new HashSet<>();
		Node aux = head;
		while (aux.next != null) {
			if (visited.contains(aux)) {
				return true;
			}
			visited.add(aux);
			aux = aux.next;
		}
		return false;
	}
	
	int findMergeNode(Node headA, Node headB) {
		
		List<Integer> setA = new ArrayList<>();
		    
	    while (headA.next != null) {
	    	setA.add(headA.data);
	    	headA = headA.next;
	    }
	    setA.add(headA.data);
	    
	    List<Integer> setB = new ArrayList<>();
	    
	    while (headB.next != null) {
	    	setB.add(headB.data);
	    	headB = headB.next;
	    }
	    setB.add(headB.data);
	   
	    for (Integer data : setA) {
	    	if (setB.contains(data)) {
	    		List<Integer> sA = setA.subList(setA.indexOf(data), setA.size());
				List<Integer> sB = setB.subList(setB.indexOf(data), setB.size());
				if (sA.equals(sB)){
	    			return data;
	    		}
	    	}
		}
	    
	    return -1;
		
	}

}
