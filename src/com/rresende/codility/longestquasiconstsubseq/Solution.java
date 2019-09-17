package com.rresende.codility.longestquasiconstsubseq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) {

		System.out.println(new Solution().solution(new int[] { 6, 10, 6, 9, 7, 8 }));
		System.out.println(new Solution().solution(new int[] { 2147483647, 2147483647 }));
		System.out.println(new Solution().solution(new int[] { 6, 10, 1, 2, 6, 6, 7 }));
		System.out.println(new Solution().solution(new int[] { 5, 5, 3, 3, 9 }));
		System.out.println(new Solution().solution(new int[] { 5, 6, 1, 3, 2, 4 }));

	}

	public int solution(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : A)
			map.compute(i, (k, v) -> v == null ? 1 : v + 1);
		int max = 0;
		for (Entry<Integer, Integer> e : map.entrySet()) {
			int t = e.getValue() + map.getOrDefault(e.getKey() + 1, 0);
			if (t > max)
				max = t;
		}
		System.out.println(Arrays.toString(A) + " -> " + max);
		return max;
	}

}
