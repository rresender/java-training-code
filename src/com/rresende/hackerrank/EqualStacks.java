package com.rresende.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class EqualStacks {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int n3 = in.nextInt();

            int h1[] = new int[n1];
            for (int h1_i = n1 - 1; h1_i >= 0; h1_i--) {
                h1[h1_i] = in.nextInt();
            }
            int h2[] = new int[n2];
            for (int h2_i = n2 - 1; h2_i >= 0; h2_i--) {
                h2[h2_i] = in.nextInt();
            }
            int h3[] = new int[n3];
            for (int h3_i = n3 - 1; h3_i >= 0; h3_i--) {
                h3[h3_i] = in.nextInt();
            }

            Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
            int sum = 0;
            for (int h1_i = 0; h1_i < h1.length; h1_i++) {
                sum += h1[h1_i];
                m1.put(sum, 1);
            }

            Map<Integer, Integer> m2 = new HashMap<Integer, Integer>();
            sum = 0;
            for (int h2_i = 0; h2_i < h2.length; h2_i++) {
                sum += h2[h2_i];
                Integer e = m1.get(sum);
                if (e != null) {
                    m2.put(sum, ++e);
                }
            }

            Map<Integer, Integer> m3 = new HashMap<Integer, Integer>();
            sum = 0;
            for (int h3_i = 0; h3_i < h3.length; h3_i++) {
                sum += h3[h3_i];
                Integer e = m2.get(sum);
                if (e != null) {
                    m3.put(sum, ++e);
                }
            }

            int max = Integer.MIN_VALUE;
            Set<Entry<Integer, Integer>> entrySet = m3.entrySet();
            for (Entry<Integer, Integer> entry : entrySet) {
                if (entry.getKey() > max) {
                    max = entry.getKey();
                }
            }

            System.out.println(max == Integer.MIN_VALUE ? 0 : max);
        }
    }
}
