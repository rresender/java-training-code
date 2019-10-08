package com.rresende.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SockMerchant {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int c_i = 0; c_i < n; c_i++) {
                int e = in.nextInt();
                Integer v = map.get(e);
                if (v == null) {
                    map.put(e, 1);
                } else {
                    map.put(e, ++v);
                }
            }

            int c = 0;
            Set<java.util.Map.Entry<Integer, Integer>> entrySet = map.entrySet();
            for (java.util.Map.Entry<Integer, Integer> entry : entrySet) {
                Integer value = entry.getValue();
                if (value > 1) {
                    c += (value / 2);
                }
            }

            System.out.println(c);
        }
    }
}
