package com.rresende.codesignal;

import java.util.Arrays;

public class AverageOfSubArrayOfSizeK {

	public static void main(String...args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		System.out.println(Arrays.toString(findAverages(2, arr)));
		int[] arr2 = {1, 3, 2, 6, -1, 4, 1, 8, 2};
		System.out.println(Arrays.toString(findAverages(5, arr2)));
	}
	
	static double[] findAverages(int k, int[] arr) {
		
		double[] result = new double[arr.length - k + 1];
		
		double windowSum = 0;
		int windowStart = 0;
		
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			if (windowEnd >= k - 1) {
				result[windowStart] = windowSum / k;
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		
		return result;
		
	}

}
