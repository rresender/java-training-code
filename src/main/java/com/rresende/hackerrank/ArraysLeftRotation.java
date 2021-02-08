package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class ArraysLeftRotation {

    @Test
    public void arraysLeftRotation() {
        assertThat(arrayLeftRotation(1, new int[]{1, 2, 3, 4, 5}), is(new int[]{2, 3, 4, 5, 1}));
        assertThat(arrayLeftRotation(2, new int[]{1, 2, 3, 4, 5}), is(new int[]{3, 4, 5, 1, 2}));
        assertThat(arrayLeftRotation(3, new int[]{1, 2, 3, 4, 5}), is(new int[]{4, 5, 1, 2, 3}));
        assertThat(arrayLeftRotation(4, new int[]{1, 2, 3, 4, 5}), is(new int[]{5, 1, 2, 3, 4}));
    }
    
    static int[] arrayLeftRotation(int k, int[] a) {
        while (k > 0) {
            int tmp = a[0];
            for (int i = 0; i < a.length - 1; i++)
                a[i] = a[i+1];
            a[a.length-1] = tmp;
            k--;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
