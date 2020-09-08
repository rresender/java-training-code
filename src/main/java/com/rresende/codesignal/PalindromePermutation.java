package com.resende.codesignal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class PalindromePermutation {

	public static boolean hasPalindromePermutation_(String theString) {
		int n = theString.length();
		if (n <= 1) {
			return true;
		}

		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			m.merge(theString.charAt(i), 1, Integer::sum);
		}

		if (m.keySet().size() <= 1) {
			return true;
		}

		int odd = 0;
		int even = 0;

		for (int v : m.values()) {
			if (v % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}

		if (odd == 0 && even > 1) {
			return true;
		}

		if (odd == 1 && even >= 2) {
			return true;
		}
		return false;
	}

	boolean hasPalindromePermutation(String s) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (set.contains(ch)) {
				set.remove(ch);
			} else {
				set.add(ch);
			}
		}
		return s.length() % 2 == 0 && set.isEmpty() || s.length() % 2 == 1 && set.size() == 1;
	}

	// tests

	@Test
	public void permutationWithOddNumberOfCharsTest() {
		final boolean result = hasPalindromePermutation("aabcbcd");
		assertTrue(result);
	}

	@Test
	public void permutationWithEvenNumberOfCharsTest() {
		final boolean result = hasPalindromePermutation("aabccbdd");
		assertTrue(result);
	}

	@Test
	public void noPermutationWithOddNumberOfChars() {
		final boolean result = hasPalindromePermutation("aabcd");
		assertFalse(result);
	}

	@Test
	public void noPermutationWithEvenNumberOfCharsTest() {
		final boolean result = hasPalindromePermutation("aabbcd");
		assertFalse(result);
	}

	@Test
	public void emptyStringTest() {
		final boolean result = hasPalindromePermutation("");
		assertTrue(result);
	}

	@Test
	public void oneCharacterStringTest() {
		final boolean result = hasPalindromePermutation("a");
		assertTrue(result);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(PalindromePermutation.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}

}
