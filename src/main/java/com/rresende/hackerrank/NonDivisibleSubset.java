package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class NonDivisibleSubset {

    @Test
    public void nonDivisibleSubset() {
        assertThat(nonDivisibleSubset(4, 3, 1, 7, 2, 4), is(3));
        assertThat(nonDivisibleSubset(5, 1, 1, 2, 3, 4, 5), is(1));
        assertThat(nonDivisibleSubset(10, 4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), is(5));
    }

    static int nonDivisibleSubset(int n, int k, int... subset) {
        int[] counts = new int[k];
        for (int i = 0; i < k; ++i)
            counts[i] = 0;

        for (int i = 0; i < n; ++i)
            counts[subset[i] % k] += 1;

        int count = counts[0] < 1 ? counts[0] : 1;
        for (int i = 1; i < k / 2 + 1; ++i)
            if (i != k - i)
                count += counts[i] > counts[k - i] ? counts[i] : counts[k - i];

        if (k % 2 == 0)
            count += 1;
        return count;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            int[] subset = new int[n];
            for (int i = 0; i < n; ++i)
                subset[i] = scan.nextInt();
            System.out.println(nonDivisibleSubset(n, k, subset));
        }
    }

}
