package com.rresende.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackTest {

    public static void main(String[] args) {

        try (final Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            java.util.Stack<Integer> stack = new java.util.Stack<>();
            java.util.Stack<Integer> mStack = new java.util.Stack<>();
            int max = Integer.MIN_VALUE;
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int t = in.nextInt();
                q.add(t);
                if (t == 1) {
                    q.add(in.nextInt());
                }
            }
            while (!q.isEmpty()) {
                int type = q.poll();
                if (type == 1) {
                    int e = q.poll();
                    stack.push(e);
                    if (e >= max) {
                        mStack.push(max);
                        max = e;
                    }
                } else if (type == 2) {
                    if (!stack.isEmpty()) {
                        Integer e = stack.pop();
                        if (e == max) {
                            max = mStack.pop();
                        }
                    }
                } else {
                    System.out.println(max);
                }
            }
        }
    }
}
