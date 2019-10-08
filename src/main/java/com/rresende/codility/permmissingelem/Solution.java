package com.rresende.codility.permmissingelem;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] {2,3,1,5}));
		System.out.println(new Solution().solution(new int[] {2,3,1,5,4,7}));
		System.out.println(new Solution().solution(new int[] {1,2}));
		System.out.println(new Solution().solution(new int[] {}));
	}
	
	public int solution(int[] A) {
		java.util.Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
			int v = i+1;
			if (A[i] == v) {
				continue;
			}
			return v;
		}
        return A.length+1;
    }
}
