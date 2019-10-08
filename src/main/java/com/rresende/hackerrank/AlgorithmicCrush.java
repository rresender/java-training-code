package com.rresende.hackerrank;

import java.util.Scanner;

public class AlgorithmicCrush {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int M = in.nextInt();
            long max = Integer.MIN_VALUE;
            long[] arr = new long[N + 1];
            for (int i = 0; i < M; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int k = in.nextInt();
                arr[a] += k;
                if ((b + 1) <= N)
                    arr[b + 1] -= k;
            }

            long x = 0;
            ;
            for (int i = 1; i <= N; i++) {
                x = x + arr[i];
                if (max < x)
                    max = x;

            }

            System.out.println(max);
        }
    }

}
