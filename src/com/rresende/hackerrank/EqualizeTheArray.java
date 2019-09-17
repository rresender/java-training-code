package com.rresende.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class EqualizeTheArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < n; i++) {
                int k = in.nextInt();
                Integer v = map.get(k);
                if (v == null) {
                    map.put(k, 1);
                } else {
                    map.put(k, ++v);
                }
            }

            TreeSet<Integer> set = new TreeSet<>(map.values());
            System.out.println(n - set.last());
        }
    }

}
