package com.rresende.codility.cyclicrotation;

import java.util.Arrays;

public class Solution {
	
	public int[] solution(int[] A, int K) {
		int count = K;
		while(count != 0) {
			int i = 0;
			for (; i < A.length-1; i++) {
				int ini = A[i];
				A[i] = A[A.length -1];
				A[A.length -1] = ini;
			}
			count--;
		}
		return A;

    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().solution(new int[]{3, 8, 9, 7, 6}, 3)));
	}
}
