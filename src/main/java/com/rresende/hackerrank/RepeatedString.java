package com.rresende.hackerrank;

import java.util.Scanner;

public class RepeatedString {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            String s = in.next();
            long n = in.nextLong();
            long c = 0;

            for (char chr : s.toCharArray()) {
                if (chr == 'a') {
                    c++;
                }
            }

            long z = (n / s.length());
            long q = (n % s.length());
            c = z * c;
            for (int i = 0; i < q; i++) {
                if (s.charAt(i) == 'a') {
                    c++;
                }
            }
            System.out.println(c);
        }

    }

}
