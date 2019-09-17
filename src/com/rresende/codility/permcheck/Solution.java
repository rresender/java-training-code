package com.rresende.codility.permcheck;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] {2,3,1,5}));
		System.out.println(new Solution().solution(new int[] {2,3,1,5,4,6}));
		System.out.println(new Solution().solution(new int[] {4, 1, 3, 2}));
		System.out.println(new Solution().solution(new int[] {4, 1, 3}));
		System.out.println(new Solution().solution(new int[] {1,2}));
		System.out.println(new Solution().solution(new int[] {}));
	}
	
	public int solution(int[] A) {
		java.util.Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
			int v = i+1;
			if (A[i] != v) {
				return 0;
			}
		}
        return 1;
    }

}
