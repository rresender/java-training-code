package com.rresende.codesignal;

public class MaxSumSubArrayOfSizeK {
	
	public static void main(String[] args) {
		
		int a = 5;
		int b = 3;
		int c = a - b +1;
		System.out.println(c);
		
		System.out.println(findMaxSumSubaarray(3, new int[]{2, 1, 5, 1, 3, 2}));
		System.out.println(findMaxSumSubaarray(2, new int[]{2, 3, 4, 1, 5}));
	}
	
	//O(n) the space O(1)
	static int findMaxSumSubaarray(int k, int[] arr) {
		
		int max = Integer.MIN_VALUE;
		int windowSum = 0;
		int windowStart = 0;
		
		for (int windowsEnd = 0; windowsEnd < arr.length; windowsEnd++) {
			
			windowSum += arr[windowsEnd];
			
			if (windowsEnd >= k - 1) {
				max = Math.max(max, windowSum);
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		
		return max;
	}

}
