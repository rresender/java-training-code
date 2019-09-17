package com.rresende.hackerrank;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (final Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            Stack<String> v = new Stack<>();
            Queue<Serializable> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                int t = in.nextInt();
                q.add(t);
                if (t == 1) {
                    q.add(in.next());
                }
                if (t == 2) {
                    q.add(in.nextInt());
                }
                if (t == 3) {
                    q.add(in.nextInt());
                }
            }

            StringBuilder b = new StringBuilder();
            while (!q.isEmpty()) {
                Serializable type = q.poll();
                if ((Integer) type == 1) {
                    String e = (String) q.poll();
                    v.push(b.toString());
                    b.append(e);
                    continue;
                }
                if ((Integer) type == 2) {
                    Integer e = (Integer) q.poll();
                    v.push(b.toString());
                    b.delete(b.length() - e, b.length());
                    continue;
                }
                if ((Integer) type == 3) {
                    Integer e = (Integer) q.poll();
                    System.out.println(b.charAt(e - 1));
                    continue;
                }

                if ((Integer) type == 4) {
                    String p = v.pop();
                    b = new StringBuilder(p);
                    continue;
                }
            }
        }
    }
}
