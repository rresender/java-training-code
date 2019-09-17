package com.rresende.hackerrank;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaBitSet {
    
    
    public static void main(String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int n = in.nextInt();
            final int m = in.nextInt();

            BitSet b1 = new BitSet(n);
            BitSet b2 = new BitSet(n);

            Map<Integer, BitSet> map = new HashMap<>();
            map.put(1, b1);
            map.put(2, b2);

            for (int i = 0; i < m; i++) {
               String op = in.next();
               
               if ("AND".equals(op)) {
                   b1 = map.get(in.nextInt());
                   b2 = map.get(in.nextInt());
                   b1.and(b2);
               } else if ("OR".equals(op)) {
                   b1 = map.get(in.nextInt());
                   b2 = map.get(in.nextInt());
                   b1.or(b2);
               } else if ("XOR".equals(op)) {
                   b1 = map.get(in.nextInt());
                   b2 = map.get(in.nextInt());
                   b1.xor(b2);
               } else if ("FLIP".equals(op)) {
                   BitSet b = map.get(in.nextInt());
                   b.flip(in.nextInt());
               } else if ("SET".equals(op)) {
                   BitSet b = map.get(in.nextInt());
                   b.set(in.nextInt());
               } 
               
               System.out.println(map.get(1).cardinality()+" "+map.get(2).cardinality());
            }
        }
    }

}
