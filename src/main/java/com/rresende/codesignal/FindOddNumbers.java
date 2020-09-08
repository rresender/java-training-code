package com.resende.codesignal;

import java.util.Arrays;

public class FindOddNumbers {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOdd(new int[] {1, 2, 3, 5})));
		System.out.println(Arrays.toString(findOdd(new int[] {1, 1, 1, 1})));
		System.out.println(Arrays.toString(findOdd(new int[] {3})));
		System.out.println(Arrays.toString(findOdd(new int[] {2, 4, 6, 8})));
	}
	
	
	static int[] findOdd(int[] arr) {
		int path = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				arr[path++] = arr[i];
			}
		}
		return Arrays.copyOf(arr, path);
	}

}
