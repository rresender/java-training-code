package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NewYearChaos {

    @Test
    public void magicSquares() {
        assertThat(prepareMinimumBribes(new int[] { 2, 1, 5, 3, 4 }), is("3"));
        assertThat(prepareMinimumBribes(new int[] { 2, 5, 1, 3, 4 }), is("Too chaotic"));
        assertThat(prepareMinimumBribes(new int[] { 5, 1, 2, 3, 7, 8, 6, 4 }), is("Too chaotic"));
        assertThat(prepareMinimumBribes(new int[] { 1, 2, 5, 3, 7, 8, 6, 4 }), is("7"));
        assertThat(prepareMinimumBribes(new int[] { 1, 2, 5, 3, 4, 7, 8, 6 }), is("4"));
    }

    static void minimumBribes(int[] q) {
        System.out.println(prepareMinimumBribes(q));
    }

    static String prepareMinimumBribes(int[] q) {
        int b = 0;
        for (int i = 0; i < q.length; i++) {
            if ((q[i] - (i + 1)) > 2)
                return "Too chaotic";
            
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) b++;
        }
        return String.valueOf(b);
    }

}
