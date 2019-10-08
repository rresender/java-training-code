package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BirthdayChocolate {

    @Test
    public void squares() {
        assertThat(solve(1, null, 1, 1), is((Object) null));
        assertThat(solve(1, new Integer[] { 1 }, 1, 1), is(1));
        assertThat(solve(2, new Integer[] { 1, 1 }, 2, 2), is(1));
        assertThat(solve(3, new Integer[] { 1, 1, 1 }, 2, 2), is(2));
        assertThat(solve(5, new Integer[] { 1, 2, 1, 3, 2 }, 3, 2), is(2));
        assertThat(solve(6, new Integer[] { 1, 1, 1, 1, 1, 1 }, 3, 2), is(0));
    }

    private Integer solve(int n, Integer[] s, int d, int m) {
        if (s == null) {
            return null;
        }

        int c = 0;
        
        for (int i = 0; i < n ; i++) {
            int sum = 0;
            for (int j = i; j < (m+i) && j < n; j++) {
                sum += s[j];
            }
            if (sum == d) {
                c++;
            }
        }
        return c;
    }

}
