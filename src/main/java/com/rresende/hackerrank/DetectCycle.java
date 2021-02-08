package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class DetectCycle {
    
    class Node {
        int data;
        Node next;
        
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        
        public Node(int data) {
            this(data, null);
        }
    }

    @Test
    public void detectCycle() {
        assertThat(hasCycle(new Node(1)), is(false));
        Node n3 = new Node(3);
        Node n2 = new Node(2, n3);
        Node head = new Node(1, n2);
        n3.next = n2;
        assertThat(hasCycle(head), is(true));
    }
    
    private boolean hasCycle(Node head) {
        if (head == null) 
            return false;

        Node slow = null;
        Node fast = null;

        slow = fast = head;

        while(true) {

            slow = slow.next;

            if (fast.next != null)
                fast = fast.next.next;
            else
                return false;

            if (slow == null || fast == null)
                return false;

            if (slow == fast)
                return true;
        }
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
