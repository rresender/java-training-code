package com.rresende.hackerrank;

import java.util.Scanner;

public class MarsExploration {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String S = in.next();
            String str = "SOS";
            int c = 0;
            for (int i = 0; i < S.length(); i++) {
                char a = S.charAt(i);
                char b = str.charAt(i % 3);
                if (a != b) {
                    c++;
                }
            }
            System.out.println(c);
        }
    }
}
