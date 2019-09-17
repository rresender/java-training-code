package com.rresende.hackerrank;

import java.util.Scanner;

public class AppendAndDelete {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            String t = in.next();
            int k = in.nextInt();

            int commonLength = 0;

            for (int i = 0; i < java.lang.Math.min(s.length(), t.length()); i++) {
                if (s.charAt(i) == t.charAt(i)) {
                    commonLength++;
                } else {
                    break;
                }
            }
            if ((s.length() + t.length() - 2 * commonLength) > k) {
                System.out.println("No");
                return;
            }
            if ((s.length() + t.length() - 2 * commonLength) % 2 == k % 2) {
                System.out.println("Yes");
                return;
            }
            if ((s.length() + t.length() - k) < 0) {
                System.out.println("Yes");
                return;
            }

            System.out.println("No");
        }
    }
}
