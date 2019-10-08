package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;


public class MarkAndToys {

    
    @Test
    public void biggerIsGreater() { 
        assertThat(maximumToys(new int[] {1, 12, 5, 111, 200, 1000, 10}, 50), is(4));
        assertThat(maximumToys(new int[] {1, 2, 3, 4}, 7), is(3));
    }
    
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int sum = prices[0];
        if (sum > k)
            return 0;
        if (sum == k)
            return 1;
        int i = 1;
        for (;i < prices.length; i++) {
            int e = prices[i];
            if (sum + e < k) {
                sum += e;
                continue;
            }
            break;
        }
        return i;
    }

}
