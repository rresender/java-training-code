package com.resende.codesignal;

import java.util.HashMap;
import java.util.Map;

public class MinimumRemovals {
		
	static int minimumRemovals(String s1, String s2) {
		
		Map<Character, Integer> counts1 = new HashMap<Character, Integer>();
		for (char c : s1.toCharArray()) {
			counts1.merge(c, 1, Integer::sum);
		}
		
		Map<Character, Integer> counts2 = new HashMap<Character, Integer>();
		for (char c : s2.toCharArray()) {
			counts2.merge(c, 1, Integer::sum);
		}
		
		int min = 0;
		for(char c: counts1.keySet()) {
			Integer c2 = counts2.get(c);
			if (c2 == null) {
				return -1;
			}
			Integer c1 = counts1.get(c);
			if (c1.equals(c2)) {
				continue;
			}
			if (Math.abs(c1 - c2) <= 2) {
				min += Math.min(c1, c2);
				continue;
			}
			return -1;
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		
		System.out.println(minimumRemovals("AABCCDE", "AABCCDE"));
		
	}

}
