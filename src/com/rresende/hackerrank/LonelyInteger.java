package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class LonelyInteger {

    @Test
    public void lonelyInteger() {
        assertThat(lonelyInteger(new int[] {1, 1, 2}), is(2));
        assertThat(lonelyInteger(new int[] {0, 0, 1, 2, 1}), is(2));
    }

    public static int lonelyInteger(int[] a) {
        int lonely = 0;
        for (int i : a)
            lonely ^= i;
        return lonely;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int a_i = 0; a_i < n; a_i++)
                a[a_i] = in.nextInt();
            System.out.println(lonelyInteger(a));
        }
    }

}
