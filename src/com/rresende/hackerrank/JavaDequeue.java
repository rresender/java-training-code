package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class JavaDequeue {
    
    @Test
    public void arraysLeftRotation() {
        
        assertThat(dequeue(new ArrayDeque<Integer>(Arrays.asList(new Integer[]{5, 3, 5, 2, 3, 2})), 3), is(3));
    }
   
    static int dequeue(Deque<Integer> deque, int k) {
        int c = 1;
        int max = 0;
        while (deque.size() >= k) {
            Set<Integer> set = new HashSet<>();
            Deque<Integer> aux = new LinkedList<Integer>();
            Integer pop = deque.pop();
            set.add(pop);
            while (c++ < k) {
                pop = deque.pop();
                aux.push(pop);
                set.add(pop);
            }
            c = 1;
            max = Math.max(max, set.size());
            while (!aux.isEmpty()) {
                deque.push(aux.pop());
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            
            final Deque<Integer> d = new ArrayDeque<>();
            final int n = in.nextInt();
            final int m = in.nextInt();
            final Set<Integer> s = new HashSet<>();
            
            int max = 0;
            
            for (int i = 0; i < n; i++) {
                final int num = in.nextInt();
                d.add(num);
                s.add(num);
                if (d.size() == m + 1) {
                    int e = (int) d.remove();
                    if (!d.contains(e)) {
                        s.remove(e);
                    }
                }
                max = Math.max(s.size(), max);
            }
            System.out.println(max);
        }
    }

}
