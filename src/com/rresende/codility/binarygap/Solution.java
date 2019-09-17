package com.rresende.codility.binarygap;

public class Solution {
	
	public int solution(int N) {
		final char[] binary = Integer.toBinaryString(N).toCharArray();
		int count = 0;
		int max = 0;
		for (char c : binary) {
			if (c == '1') {
				if (count > max) {
					max = count;
				}
				count = 0;
				continue;
			}
			count++;
		}
		
		return max;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution(1041));
		System.out.println(new Solution().solution(1001));
		System.out.println(new Solution().solution(529));
		System.out.println(new Solution().solution(20));
		System.out.println(new Solution().solution(32));
	}
}
