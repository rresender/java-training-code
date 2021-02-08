package com.rresende.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TwoSum {

	@Test
	public void commonChild() {
		assertThat(twoSum(new int[] { 2, 7, 11, 15 }, 9), is( new int[] {0, 1}));
		assertThat(twoSum(new int[] { 2, 7, 11, 15 }, 26), is( new int[] {2, 3}));
		assertThat(twoSum(new int[] { 3, 2, 4 }, 6), is( new int[] {1, 2}));
		assertThat(twoSum(new int[] { 3, 2, 3 }, 6), is( new int[] {0, 2}));
	}

	public static int[] twoSum(final int[] nums, final int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (sum == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[]{};
	}

}
