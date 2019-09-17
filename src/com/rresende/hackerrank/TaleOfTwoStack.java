package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;
import java.util.Stack;

import org.junit.Test;

public class TaleOfTwoStack {
    
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) {
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if (isEmpty())
                return null;
            if (stackOldestOnTop.isEmpty())
                moveAll();
            return stackOldestOnTop.peek();
        }

        private void moveAll() {
            while (!stackNewestOnTop.isEmpty())
                stackOldestOnTop.push(stackNewestOnTop.pop());
        }

        public T dequeue() {
            if (isEmpty()) 
                return null;
            if (stackOldestOnTop.isEmpty())
                moveAll();
            return stackOldestOnTop.pop();
        }
        
        private boolean isEmpty() {
            return stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty();
        }
    }

    @Test
    public void taleOfTwoStack() {
        MyQueue<Integer> q = new MyQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertThat(q.dequeue(), is(1));
        assertThat(q.peek(), is(2));
        assertThat(q.dequeue(), is(2));
        assertThat(q.peek(), is(3));
    }
    
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
