package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class DavisStaircase {

    @Test
    public void arraysLeftRotation() {
        assertThat(stepPerms(1), is(1));
        assertThat(stepPerms(3), is(4));
        assertThat(stepPerms(7), is(44));
    }
    
    static int stepPerms(int n) {
        int[] a = new int[n];
        if (n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(n == 3) {
            return 4;
        }
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        for (int i = 3; i < n; i++) {
            a[i] = a[i-1] + a[i-2] + a[i-3];
        }
        return a[a.length-1];
    }

}
