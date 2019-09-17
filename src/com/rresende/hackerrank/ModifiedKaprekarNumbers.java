package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class ModifiedKaprekarNumbers {

    @Test
    public void modifiedKaprekarNumbers() {
        assertThat(modifiedKaprekarNumbers(1L, 100L), is(Arrays.asList(new Integer[] {1, 9, 45, 55, 99})));
        assertThat(modifiedKaprekarNumbers(1L, 99999L), is(Arrays.asList(new Integer[] {1, 9, 45, 55, 99, 297, 703, 999, 2223, 2728, 4950, 5050, 7272, 7777, 9999, 17344, 22222, 77778, 82656, 95121, 99999})));
        assertThat(modifiedKaprekarNumbers(400L, 700L), is(Arrays.asList(new Integer[] {})));
    }

    static List<Integer> modifiedKaprekarNumbers(Long p, Long q) {
        List<Integer> result = new ArrayList<>();
        while (p <= q) {
            long x = p * p;
            String s = String.valueOf(x);
            int half = s.length()/2;
            
            String l = s.substring(0, half);
            String r = s.substring(half, s.length());
            
            long p1 = Long.parseLong(l.equals("") ? "0" : l);
            long p2 = Long.parseLong(r.equals("") ? "0" : r);

            if (p1 + p2 == p)
                result.add(p.intValue());
            p++;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            long p = in.nextLong();
            long q = in.nextLong();
            List<Integer> l = modifiedKaprekarNumbers(p, q);
            if (l.isEmpty()) { 
                System.out.println("INVALID RANGE");
            } else {
                for (Integer n: l){
                    System.out.print(n+" ");
                }
            }
        }
    }

}
