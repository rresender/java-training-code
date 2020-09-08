package com.resende.codesignal;

public class MinSizeSubArraySum {

	public static void main(String[] args) {
		
		System.out.println(findMinSubarray(7, new int[]{2, 1, 5, 2, 3, 2}));
		System.out.println(findMinSubarray(7, new int[]{2, 1, 5, 2, 8}));
		System.out.println(findMinSubarray(8, new int[]{3, 4, 1, 1, 6}));
	}
	
	static int findMinSubarray(int S, int[] arr) {
		
		int min = Integer.MAX_VALUE;
		int windowSum = 0;
		int windowStart = 0;
		
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			while (windowSum >= S) {
				min = Math.min(min, windowEnd - windowStart + 1);
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
				
		return min == Integer.MAX_VALUE ? 0 : min;
		
	}

}
