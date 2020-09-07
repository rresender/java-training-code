package com.rresende.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SparseArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (final Scanner in = new Scanner(System.in)) {
			final int n = in.nextInt();
			final List<String> strings = new ArrayList<>();
			final List<String> queries = new ArrayList<>();
			final Map<String, Integer> values = new HashMap<String, Integer>();

			int count = 0;
			while (count++ < n) {
				strings.add(in.next());
			}

			count = 0;
			int q = in.nextInt();
			while (count++ < q) {
				queries.add(in.next());
			}

			for (String s : strings) {
				if (queries.contains(s)) {
					Integer value = values.get(s);
					if (value == null) {
						values.put(s, 1);
					} else {
						values.put(s, ++value);
					}
				}
			}

			for (String s : queries) {
				Integer integer = values.get(s);
				if (integer == null) {
					integer = 0;
				}
				System.out.println(integer + " ");
			}
		}
	}

}
