package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class ServiceLane {

    @Test
    public void serviceLane() {
        assertThat(serviceLane(0, 3, new int[]{2, 3, 1, 2, 3, 2, 3, 3}), is(1));
        assertThat(serviceLane(4, 6, new int[]{2, 3, 1, 2, 3, 2, 3, 3}), is(2));
        assertThat(serviceLane(6, 7, new int[]{2, 3, 1, 2, 3, 2, 3, 3}), is(3));
        assertThat(serviceLane(3, 5, new int[]{2, 3, 1, 2, 3, 2, 3, 3}), is(2));
        assertThat(serviceLane(0, 7, new int[]{2, 3, 1, 2, 3, 2, 3, 3}), is(1));
        
        assertThat(serviceLane(2, 3, new int[]{1, 2, 2, 2, 1}), is(2));
        assertThat(serviceLane(1, 4, new int[]{1, 2, 2, 2, 1}), is(1));
        assertThat(serviceLane(2, 4, new int[]{1, 2, 2, 2, 1}), is(1));
        assertThat(serviceLane(2, 4, new int[]{1, 2, 2, 2, 1}), is(1));
        assertThat(serviceLane(2, 3, new int[]{1, 2, 2, 2, 1}), is(2));
    }
    

    static int serviceLane(int i, int j, int[] widths) {
        int[] c = Arrays.copyOfRange(widths, i, j+1);
        Arrays.sort(c);
        return c[0];
    }


    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
