package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class JumpingOnTheClouds {
    
    @Test
    public void jumpingOnTheClouds() {
        assertThat(jumpingOnTheClouds(new int[]{0, 0, 1, 0, 0, 1, 0}), is(4));
        assertThat(jumpingOnTheClouds(new int[]{0, 0, 0, 0, 1, 0}), is(3));
        assertThat(jumpingOnTheClouds(new int[]{0, 0, 0, 1, 0, 0}), is(3));
    }
    
    static int jumpingOnTheClouds(int[] clouds) {
        Set<Integer> jumps = new HashSet<>();
        jumps.add(0);
        for (int i = 2; i < clouds.length; i+=2) {
            if (clouds[i] == 1)
                i--;
            jumps.add(i);
        }
        jumps.add(clouds.length-1);
        return jumps.size()-1;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
           
        }
    }

}
