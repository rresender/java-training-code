package com.rresende.hackerrank;

import java.util.Scanner;

public class CircularArrayRotation {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();
            int q = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }

            rotate(a, k);

            for (int a0 = 0; a0 < q; a0++) {
                int m = in.nextInt();
                System.out.println(a[m]);
            }
        }
    }

    static void rotate(int[] nums, int k) {

        if (k > nums.length)
            k = k % nums.length;

        int[] result = new int[nums.length];

        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }

        int j = 0;
        for (int i = k; i < nums.length; i++) {
            result[i] = nums[j];
            j++;
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
    }

}
