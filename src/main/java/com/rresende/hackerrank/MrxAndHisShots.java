package com.rresende.hackerrank;

import java.util.Arrays;

public class MrxAndHisShots {

	public static void main(String[] args) {
		int[][] s = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 5 }, { 6, 7 } };
		int[][] p = new int[][] { { 1, 5 }, { 2, 3 }, { 4, 7 }, { 5, 7 } };
		System.out.println(solve(s, p));
	}

	public static int right(int[] arr, int x) {
		return right(arr, x, 0, arr.length);
	}

	public static int right(int[] arr, int x, int lo, int hi) {
		int n = arr.length;
		if (n == 0) {
			return 0;
		}
		if (x < arr[lo]) {
			return lo;
		}
		if (x > arr[hi - 1]) {
			return hi;
		}
		for (;;) {
			if (lo + 1 == hi) {
				return lo + 1;
			}
			int mi = (hi + lo) / 2;
			if (x < arr[mi]) {
				hi = mi;
			} else {
				lo = mi;
			}
		}
	}

	public static int left(int[] arr, int x) {
		return left(arr, x, 0, arr.length);
	}

	public static int left(int[] arr, int x, int lo, int hi) {
		int n = arr.length;
		if (n == 0) {
			return 0;
		}
		if (x < arr[lo]) {
			return lo;
		}
		if (x > arr[hi - 1]) {
			return hi;
		}
		for (;;) {
			if (lo + 1 == hi) {
				return x == arr[lo] ? lo : (lo + 1);
			}
			int mi = (hi + lo) / 2;
			if (x <= arr[mi]) {
				hi = mi;
			} else {
				lo = mi;
			}
		}
	}

	static int solve(int[][] shots, int[][] players) {
		final int[] start = Arrays.stream(shots).map(s -> s[0]).sorted().mapToInt(i -> i).toArray();
		final int[] end = Arrays.stream(shots).map(s -> s[1]).sorted().mapToInt(i -> i).toArray();
		int count = 0;
		for (int[] player : players) {
			int right = right(start, player[1]);
			int left = left(end, player[0]);
			count += right - left;
		}
		return count;
	}

}
