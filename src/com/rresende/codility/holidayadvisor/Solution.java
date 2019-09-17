package com.rresende.codility.holidayadvisor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	
	public int solution(int[] A) {
		final Set<Integer> locations = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			locations.add(A[i]);
		}
		
		int shortestVacation = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			final List<Integer> list = new ArrayList<>();
			list.add(A[i]);
			for (int j = i + 1; j < A.length; j++) {
				list.add(A[j]);
				if (list.size() < locations.size()) {
					continue;
				}
				if (list.containsAll(locations)) {
					shortestVacation = Math.min(shortestVacation, list.size());
				}
			}
		}
		return shortestVacation;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[]{7, 3, 7, 3, 1, 3, 4, 1}));
		System.out.println(new Solution().solution(new int[]{2, 1, 1, 3, 2, 1, 1, 3}));
		System.out.println(new Solution().solution(new int[]{7, 5, 2, 7, 2, 7, 4, 7}));
		System.out.println(new Solution().solution(new int[]{1, 1, 3, 2, 3, 1}));
		System.out.println(new Solution().solution(new int[]{1, 1, 1, 1, 1, 2}));
		System.out.println(new Solution().solution(new int[]{1, 5, 9, 9, 9, 9 , 9, 9}));
		System.out.println(new Solution().solution(new int[]{0, 1, 0, 3, 2}));
	}

}
