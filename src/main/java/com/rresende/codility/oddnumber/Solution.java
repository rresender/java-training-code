package com.rresende.codility.oddnumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] {9, 3, 9, 3, 9, 9, 7}));
	}
	
	public int solution(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : A)
			map.compute(i, (k, v) -> v == null ? 1 : v + 1);
		
		for (Entry<Integer, Integer> e : map.entrySet()) {
			int t = e.getValue();
			if (t % 2 != 0) {
				return e.getKey();
			}
		}
		return 0;
    }

}
