package com.rresende.codesignal;

public class StringOperations {
	
	public static void main(String[] args) {
		System.out.println(reverse("resende"));
		System.out.println(sort("cba"));
	}

	static String reverse(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length/2; i++) {
			char tmp = chars[i];
			chars[i] = chars[chars.length-1-i];
			chars[chars.length-1-i] = tmp;
		}
		return String.valueOf(chars);
	}
	
	static String sort(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			for (int j = i+1; j < chars.length; j++) {
				if (chars[i] > chars[j]) {
					char tmp = chars[i];
					chars[i] = chars[j];
					chars[j] = tmp;
				}
			}
		}		
		return String.valueOf(chars);
	}
	
}
