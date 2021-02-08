package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class BubbleSort {

    @Test
    public void sort() {
        assertThat(sort(new int[]{3, 2, 1}), is(3));
        assertThat(sort(new int[]{3, 6, 0, 2, 1}), is(7));
    }
    
    static int sort(int[] a) {
        int n = a.length;
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swaps++;
                }
            }
            if (swaps == 0) {
                break;
            }
        }
        return swaps;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++)
                a[a_i] = in.nextInt();
            int swaps = sort(a);
            System.out.println("Array is sorted in "+swaps+" swaps.");
            System.out.println("First Element: "+a[0]);
            System.out.println("Last Element: "+a[a.length-1]);
        }
    }
}
