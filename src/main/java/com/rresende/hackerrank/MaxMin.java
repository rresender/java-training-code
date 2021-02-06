package com.rresende.hackerrank;

import java.util.Arrays;

public class MaxMin {
	
	public static void main(String[] args) {
	
//		System.out.println(findMaxMin(3, new int[]{2, 1, 5, 1, 3, 2}));
//		System.out.println(findMaxMin(2, new int[]{2, 3, 4, 1, 5}));
//		System.out.println(findMaxMin(3, new int[]{10, 100, 300, 200, 1000, 20, 30}));
		System.out.println(findMaxMin(3, new int[]{100, 200, 300, 350, 400, 401, 402}));
		
	}
	
	//O(n) the space O(1)
	static int findMaxMin(int k, int[] arr) {
		Arrays.sort(arr);
		int mm = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length-k+1; i++) {
			int c = 0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			while(c < k) {
				System.out.print(arr[i+c]+" ");
				min = Math.min(min, arr[i+c]);
				max = Math.max(max, arr[i+c]);
				c++;
			}
			System.out.println();
			mm = Math.min(mm, Math.abs(max - min));
		}
		return mm;
	}

}
