package com.rresende.codility.phonebilling;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Solution {
	
	public int solution(String S) throws Exception {
		
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
	    format.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		String[] entries = S.split("\n");
		for (String e : entries) {
			String[] row = e.split(",");
			String d = row[0];
			Date dt = format.parse(d);
			long secs = dt.getTime() / 1000L;
			System.out.println(secs);
			String n = row[1];
			System.out.println(n);
		}
		
		return -1;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new Solution().solution("00:01:07,400-234-090\n" + 
				"   00:05:01,701-080-080\n" + 
				"   00:05:00,400-234-090"));
	}

}
