package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class MinimumDistances {

    @Test
    public void minimumDistances() {
        assertThat(minimumDistances(new int[]{7, 1, 3, 4, 1, 7}), is(3));
    }
    
    static int minimumDistances(int[] d) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < d.length; i++)
            for (int j = i+1; j < d.length; j++)
                if (d[i] == d[j]) 
                    min = Math.min(min, (Math.abs(j-i)));
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
