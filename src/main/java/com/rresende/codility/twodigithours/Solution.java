package com.rresende.codility.twodigithours;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
	
	public int solution(String S, String T) {

		int c = 0;
		
		final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
		final LocalTime s = LocalTime.parse(S, fmt);
		final LocalTime e = LocalTime.parse(T, fmt);
		
		for (LocalTime counter = s; counter.compareTo(e) <= 0; counter = counter.plusSeconds(1)) {
			if (isInteresting(fmt.format(counter))) {
				c++;
			}
		}
		return c;
	}
	
	boolean isInteresting(String s) {
		return Arrays.asList(s.split(":")).stream().collect(Collectors.joining()).chars().boxed().collect(Collectors.toMap(w -> w, w -> 1, Integer::sum)).values().size() < 3 ? true : false;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().solution("15:15:00", "15:15:12"));
		System.out.println(new Solution().solution("22:22:21", "22:22:23"));
		System.out.println(new Solution().solution("00:00:01", "00:00:03"));
		System.out.println(new Solution().solution("00:00:00", "23:59:58"));
	}

}
