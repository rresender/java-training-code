package com.rresende.codility.frogriverone;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		System.out.println(new Solution().solution(2, new int[] { 1, 1, 1, 1 }));
		System.out.println(new Solution().solution(3, new int[] { 1, 3, 1, 3, 2, 1, 3 }));
	}

	public int solution(int X, final int[] A) {
		Map<Integer, Boolean> collect = new TreeMap<>();
		if (X >= 30000) 
			collect = IntStream.rangeClosed(1, X).boxed().collect(Collectors.toMap(s -> s, s -> false));
		else  
			while (X >= 1) {
				collect.put(X--, false);
			}
		for (int i = 0; i < A.length; i++) {
			final Integer k = A[i];
			collect.remove(k);
			if (collect.isEmpty())
				return i;
		}
		return -1;
	}

}
