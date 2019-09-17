package com.rresende.hackerrank;

import java.util.Scanner;

public class BonAppetit {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }

            int c = in.nextInt();

            int sum = 0;
            for (int a_i = 0; a_i < a.length; a_i++) {
                sum += a[a_i];
            }

            int v = sum - a[k];
            if ((v / 2) == c) {
                System.out.println("Bon Appetit");
            } else {
                System.out.println(c - (v / 2));
            }
        }
    }

}
