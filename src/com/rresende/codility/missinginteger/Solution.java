package com.rresende.codility.missinginteger;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	
	public int solution(final int[] A){
		Arrays.sort(A);
		final Map<Integer, Integer> collect = IntStream.rangeClosed(1, A[A.length-1]+1).boxed().collect(Collectors.toMap(s -> s, s -> s));
		for (int i = 0; i < A.length; i++) {
			collect.remove(A[i]);
		}
		return collect.keySet().isEmpty() ? 1 : collect.values().iterator().next();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[]{1, 3, 6, 4, 1, 2}));
		System.out.println(new Solution().solution(new int[]{2}));
		System.out.println(new Solution().solution(new int[]{1, 2, 3}));
		System.out.println(new Solution().solution(new int[]{2, 3, 4}));
		System.out.println(new Solution().solution(new int[]{-1, -3}));
	}

}
