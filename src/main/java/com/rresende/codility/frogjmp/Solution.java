package com.rresende.codility.frogjmp;

public class Solution {
	
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution(10, 85, 30));
		System.out.println(new Solution().solution(5, 70, 15));
		System.out.println(new Solution().solution(0, 60, 15));
		System.out.println(new Solution().solution(15, 60, 15));
	}
	
	public int solution(final int X, final int Y, final int D) {
		if ((Y - X) % D == 0) {
		    return (Y - X) / D;
		}
		return (Y - X) / D + 1;
    }

}
