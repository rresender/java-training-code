package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class FriendCircleQueries {

    @Test
    public void maxCircle() {
        assertThat(maxCircle(new int[][] {{1, 2}, {3, 4}, {2, 3}}), is(Arrays.asList(new Integer[] {2, 2, 4}).stream().mapToInt(i->i).toArray()));
        assertThat(maxCircle(new int[][] {{1, 2}, {1, 3}}), is(Arrays.asList(new Integer[] {2, 3}).stream().mapToInt(i->i).toArray()));
        assertThat(maxCircle(new int[][] {{1000000000, 23}, {11, 3778}, {7, 47}, {11, 1000000000}}), is(Arrays.asList(new Integer[] {2, 2, 2, 4}).stream().mapToInt(i->i).toArray()));
        assertThat(maxCircle(new int[][] {{1, 2}, {3, 4}, {1, 3}, {5, 7}, {5, 6}, {7, 4}}), is(Arrays.asList(new Integer[] {2, 2, 4, 4, 4, 7}).stream().mapToInt(i->i).toArray()));        
    }
    
    static int[] maxCircle(int[][] queries) {
        DisjointUnionSets djs = new DisjointUnionSets();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            djs.union(queries[i][0], queries[i][1]);
            res[i] = djs.max;
        }
        return res;
    }
      
    static class DisjointUnionSets {
        
        final Map<Integer, Integer> p;
        final Map<Integer, Integer> ss;
        int max;
        
        public DisjointUnionSets() {
            p = new HashMap<>();
            ss = new HashMap<>();
            max = 0;
        }
        
        void union(final int v1, final int v2) {

            addIfNeeded(v1);
            addIfNeeded(v2);
            
            final int n = find(v1);
            final int m = find(v2);
            
            if (n == m) {
                return;
            }
            
            final int s1 = ss.get(n);
            final int s2 = ss.get(m);
            
            if (s1 < s2) {
                p.put(n, m);
                ss.put(m, s1 + s2);
                if (s1 + s2 > max) {
                    max = s1 + s2;
                }
            } else {
                p.put(m, n);
                ss.put(n, s1 + s2);
                if (s1 + s2 > max) {
                    max = s1 + s2;
                }
            }
        }

         void addIfNeeded(int v) {
            if (!p.containsKey(v)) {
                p.put(v, v);
                ss.put(v, 1);
            }
        }

        int find(int v) {
            while (p.get(v) != v) {
                p.put(v, p.get(p.get(v)));
                v = p.get(v);
            }
            return v;
        }
    }
    
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
