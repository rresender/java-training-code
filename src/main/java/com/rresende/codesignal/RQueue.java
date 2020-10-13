package com.rresende.codesignal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RQueue {
	
	
	private final Stack<Integer> s1 = new Stack<Integer>();
	private final Stack<Integer> s2 = new Stack<Integer>();
	
	public void enqueue(int data) {
		if (s1.isEmpty()) {
			s1.push(data);
			return;
		}
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(data);
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public int dequeue() {
		if (s1.isEmpty()) {
			throw new IllegalStateException("The queue is empty");
		}
		return s1.pop();
	}
	
	public static void main(String[] args) {
		
		RQueue q1 = new RQueue();
		Queue<Integer> q2 = new LinkedList<>();
		
		q1.enqueue(1);
		q2.offer(1);
		
		q1.enqueue(2);
		q2.offer(2);
		
		q1.enqueue(3);
		q2.offer(3);
		
		q1.enqueue(4);
		q2.offer(4);
		
		while(!q2.isEmpty()) {
			System.out.println(q1.dequeue() == q2.poll());
		}
	}
	

}
