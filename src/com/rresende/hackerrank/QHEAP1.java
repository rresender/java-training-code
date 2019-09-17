package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.junit.Test;

public class QHEAP1 {
    
    @Test
    public void qheap1() {
        assertThat(qheap1(Arrays.asList(new Task[]{new Task(1, 4), new Task(1, 9), new Task(3), new Task(2, 4), new Task(3) })), is(Arrays.asList(new Integer[] {4, 9})));
    }
    
    static class Task {
        int operation;
        Integer value;
        public Task(int operatio, Integer value) {
            this.operation = operatio;
            this.value = value;
        }
        
        public Task(int operatio) {
            this(operatio, null);
        }
        
    }

    static List<Integer> qheap1(List<Task> tasks) {
        Stack<Integer> s = new Stack<>();
        List<Integer> r = new ArrayList<>();
        for (Task t : tasks) {
            if (t.operation == 1)
                s.push(t.value);
            else if ((t.operation == 2))
                s.remove(t.value);
            else {
                int min = s.peek();
                for (Integer e : s)
                    min = Math.min(min, e);
                r.add(min);
            }
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)){
            final int n = in.nextInt();
            Stack<Integer> s = new Stack<>();
            Set<Integer> min = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                final int o = in.nextInt();
                if (o == 1) {
                    s.push(in.nextInt());
                    min.add(s.peek());
                }
                else if (o == 2) {
                    Integer x = new Integer(in.nextInt());
                    min.remove(x);
                    s.remove(x);
                }
                else {
                    System.out.println(min.iterator().next());
                }
            }
        }
    }

}
