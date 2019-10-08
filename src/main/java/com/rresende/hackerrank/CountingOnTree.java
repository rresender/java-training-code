
package com.rresende.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CountingOnTree {

    public static void main(String[] args) throws IOException {

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        new BufferedWriter(new OutputStreamWriter(System.out));

        final String[] first = reader.readLine().split(" ");
        final int n = Integer.parseInt(first[0]);
        final int q = Integer.parseInt(first[1]);

        final String[] treeValues = reader.readLine().split(" ");

        final int[] tree = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            final String[] nodes = reader.readLine().split(" ");
            final int u = Integer.parseInt(nodes[0]);
            final int v = Integer.parseInt(nodes[1]);
            tree[Math.max(u, v)] = Math.min(u, v);
        }

        final Map<String, List<Integer>> m = new LinkedHashMap<>();
        for (int i = 0; i < q; i++) {
            final String[] queries = reader.readLine().split(" ");
            final int w = Integer.parseInt(queries[0]);
            final int x = Integer.parseInt(queries[1]);
            final int y = Integer.parseInt(queries[2]);
            final int z = Integer.parseInt(queries[3]);
            fisrtTraverse(m, treeValues, tree, w, x);
            System.out.println(secondTraverse(m, treeValues, tree, y, z));
            m.clear();
        }
    }

    static void fisrtTraverse(Map<String, List<Integer>> m, String[] values, int[] tree, int node1, int node2) {
        int s = node1;
        int e = node2;
        while (s != e) {
            if (s > e) {
                prepareMap(m, values[s - 1], s);
                s = tree[s];
            } else {
                prepareMap(m, values[e - 1], e);
                e = tree[e];
            }
        }
        prepareMap(m, values[e - 1], e);
    }

    static int secondTraverse(Map<String, List<Integer>> m, String[] values, int[] tree, int node1, int node2) {
        int s = node1;
        int e = node2;
        int count = 0;
        while (s != e) {
            if (s > e) {
                count += countMap(m, values[s - 1], s);
                s = tree[s];
            } else {
                count += countMap(m, values[e - 1], e);
                e = tree[e];
            }
        }
        count += countMap(m, values[e - 1], e);
        return count;
    }

    static void prepareMap(Map<String, List<Integer>> m, String value, int node) {
        List<Integer> set = m.get(value);
        if (set == null) {
            set = new ArrayList<Integer>();
            m.put(value, set);
        }
        set.add(node);
    }

    static int countMap(Map<String, List<Integer>> m, String value, int node) {
        List<Integer> set = m.get(value);
        return (set == null ? 0 : set.size() + (set.contains(node) ? -1 : 0));
    }
    
    static int chainNo=0,chainHead[],chainPos[],chainInd[],chainSize[];
    
    static void hdl(int current) {
        
        if (chainHead[chainNo] == -1) chainHead[chainNo]=current;
        
    }

}
