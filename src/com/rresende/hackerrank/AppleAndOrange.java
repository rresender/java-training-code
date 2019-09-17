package com.rresende.hackerrank;

import java.util.Scanner;

public class AppleAndOrange {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            int s = in.nextInt();
            int t = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int m = in.nextInt();
            int n = in.nextInt();
            int[] apple = new int[m];
            int ca = 0;
            int co = 0;
            for (int apple_i = 0; apple_i < m; apple_i++) {
                apple[apple_i] = in.nextInt();
                int v = a + apple[apple_i];
                if (v >= s && v <= t) {
                    ca++;
                }
            }
            int[] orange = new int[n];
            for (int orange_i = 0; orange_i < n; orange_i++) {
                orange[orange_i] = in.nextInt();
                int v = b + orange[orange_i];
                if (v >= s && v <= t) {
                    co++;
                }
            }

            System.out.println(ca);
            System.out.println(co);
        }

    }

}
