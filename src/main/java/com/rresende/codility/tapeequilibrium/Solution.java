package com.rresende.codility.tapeequilibrium;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] {3, 1, 2, 4, 3}));
	}
	
	public int solution(int A[]) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum+=A[i];
		}
		
		int p1 = 0;
		for (int i = 0; i < A.length-1; i++) {
			p1 += A[i];
			int p2 = sum - p1;
			int abs = Math.abs(p1-p2);
			if (abs < min)
				min = abs;
		}
		return min;
	}

}
