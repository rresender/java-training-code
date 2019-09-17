package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class Candies {
    
    @Test
    public void candies() {
        assertThat(candies(3, new int[]{1, 2, 2}), is(4L));
    }

    static long candies(final int n, final int[] arr) {
        final long[] candies = new long[n];
        Arrays.fill(candies, 1);
        
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                candies[i] = candies[i-1] + 1; 
            }
        }
        
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1); 
            }
        }
        return Arrays.stream(candies).sum();
    }
}
