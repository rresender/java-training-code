package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class MinimumSwaps2 {

    @Test
    public void minimumSwaps() {
        assertThat(minimumSwaps(new int[] {4, 3, 1, 2}), is(3));
        assertThat(minimumSwaps(new int[] {2, 3, 4, 1, 5}), is(3));
        assertThat(minimumSwaps(new int[] {1, 3, 5, 2, 4, 6, 8}), is(3));
    }
    
   
    static void swap(int[] arr, int i) {
        int t = arr[arr[i] - 1];
        arr[arr[i] - 1] = arr[i];
        arr[i] = t;
    }
    
    static int minimumSwaps(int[] arr) {
        int c = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == (i+1))
                continue;
            swap(arr, i);
            c++;
            i--;
        }
        return c;
    }

}
