package com.rresende.hackerrank;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountingOnTree2 {

	public static void main(String[] args) throws IOException {
		
		long start = System.currentTimeMillis();
		
		System.setIn(new FileInputStream(new File("input05.txt")));
		
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
		
		System.out.println(System.currentTimeMillis()-start);
		final Map<Long, Set<Long>> m = new HashMap<>();
		for (int i = 0; i < q; i++) {
			final String[] queries = reader.readLine().split(" ");
			final int w = Integer.parseInt(queries[0]);
			final int x = Integer.parseInt(queries[1]);
			final int y = Integer.parseInt(queries[2]);
			final int z = Integer.parseInt(queries[3]);
	        path(m, treeValues, tree, w, x, 0, 0);
	        System.out.println(path(m, treeValues, tree, y, z, 1, 0));
	        m.clear();
		}
		
		System.out.println(System.currentTimeMillis()-start);
	}

	private static int path(Map<Long, Set<Long>> m, String[] values, int[] tree, int node1, int node2, int idx, int acc) {
        if (node1 == node2) {
            return buildMap(m, Integer.parseInt(values[node1 - 1]), node1, idx, acc);
        }
        if (node1 > node2) {
            return path(m, values, tree, tree[node1], node2, idx, buildMap(m, Integer.parseInt(values[node1 - 1]), node1, idx, acc));
        }
        return path(m, values, tree, node1, tree[node2], idx, buildMap(m, Long.parseLong(values[node2 - 1]), node2, idx, acc));
    }
 
    private static int buildMap(Map<Long, Set<Long>> m, long value, int node, int idx, int acc) {
        if (idx == 0) {
            Set<Long> set = m.get(value);
            if (set == null) {
                set = new HashSet<>();
                m.put(value, set);
            }
            set.add((long)node);
            return 0;
        }
        Set<Long> set = m.get(value);
        return acc + (set == null ? 0 : set.size() + (set.contains((long)node) ? -1 : 0));
    }

}
