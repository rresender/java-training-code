package com.rresende.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters {

	@Test
	public void lengthOfLongestSubstring() {
		assertThat(lengthOfLongestSubstring("dvdf"), is(3));
		assertThat(lengthOfLongestSubstring("abcabcb"), is(3));
		assertThat(lengthOfLongestSubstring("bbbbb"), is(1));
		assertThat(lengthOfLongestSubstring("pwwkew"), is(3));
		assertThat(lengthOfLongestSubstring("wwkewwp"), is(3));
		assertThat(lengthOfLongestSubstring(""), is(0));
	}

	void check(Set<String> sub, String[] strings, int i) {
		String string = strings[i];
		if (sub.contains(string)) {
			sub.clear();
			sub.add(string);
		} else {
			sub.add(string);
		}
	}
	
	public int lengthOfLongestSubstringBruteForce(final String s) {
		if (s == null || s.isEmpty())
            return 0;
		final String[] strings = s.split("");
		int max = 0;
		for (int i = 0; i < strings.length; i++) {
			Set<String> sub = new HashSet<>();
			check(sub, strings, i);
			max = Math.max(max, sub.size());
			for (int j = i+1; j < strings.length; j++) {
				check(sub, strings, j);
				max = Math.max(max, sub.size());
			}
		}
		return max; 
	}
	
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        final Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return max;
    }

}
