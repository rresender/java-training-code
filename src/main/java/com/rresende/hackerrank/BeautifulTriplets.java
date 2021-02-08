package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class BeautifulTriplets {

    @Test
    public void beautifulTriplets() {
        assertThat(beautifulTriplets(3, new HashSet<Integer>(Arrays.asList(new Integer[] { 1, 2, 4, 5, 7, 8, 10 }))),is(3));
    }

    static int beautifulTriplets(int d, Set<Integer> s) {
        int c = 0;
        for (Integer v : s)
            if (s.contains((v + d)) && s.contains((v + 2 * d)))
                c++;
        return c;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int d = in.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++)
                set.add(in.nextInt());
            System.out.println(beautifulTriplets(d, set));
        }
    }

}
