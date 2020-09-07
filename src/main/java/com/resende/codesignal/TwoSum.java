package com.resende.codesignal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TwoSum {

	@Test
	public void test() {
		assertThat(twoSum(new int[] { 2, 7, 11, 15 }, 9), equalTo(new int[] { 0, 1 }));
		assertThat(twoSum(new int[] { 2, 7, 11, 15 }, 26), equalTo(new int[] { 2, 3 }));
		assertThat(twoSum(new int[] { 3, 2, 4 }, 6), equalTo(new int[] { 1, 2 }));
		assertThat(twoSum(new int[] { 3, 2, 3 }, 6), equalTo(new int[] { 0, 2 }));
	}
	
	@Test
	public void test1() {
		assertTrue(hasPairWithSum(new int[] { 2, 7, 11, 15 }, 9));
		assertTrue(hasPairWithSum(new int[] { 15, 2, 7, 11, 3 }, 5));
		assertTrue(hasPairWithSum(new int[] { 16, 2, 7, 11, 8}, 15));
	}

	int[] twoSum(final int[] nums, final int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] { map.get(nums[i]), i };
			} else {
				map.put(target - nums[i], i);
			}
		}
		return new int[] {};
	}
	
	boolean hasPairWithSum(int[] arr, int k) {
		Set<Integer> set = new HashSet<>();
		for (Integer e : arr) {
			if (set.contains(e)) {
				return true;
			}
			set.add(Math.abs(k - e));
		}
		return false;
	}

}
