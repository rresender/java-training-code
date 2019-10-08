package com.rresende.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class BetweenTwoSets {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for (int b_i = 0; b_i < m; b_i++) {
                b[b_i] = in.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int init = a[0];
            int end = b[b.length - 1];
            int count = 0;
            for (int i = init; i <= end; i++) {
                if (factors(i, a) && factor(i, b)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean factors(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (num % arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean factor(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % num != 0) {
                return false;
            }
        }
        return true;
    }

}
