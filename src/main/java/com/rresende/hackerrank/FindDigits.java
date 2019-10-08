package com.rresende.hackerrank;
import java.util.Scanner;

public class FindDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
    		int t = in.nextInt();
    		int c = 0;
    		for (int a0 = 0; a0 < t; a0++) {
    			int n = in.nextInt();
    			int[] digits = getDigitsOf(n);
    			for (int d : digits) {
    				if (d == 0) {
    					continue;
    				}
    				if (n % d == 0) {
    					c++;
    				}
    			}
    			System.out.println(c);
    			c=0;
    		}
		}
	}

	static int[] getDigitsOf(int num) {
		int digitCount = Integer.toString(num).length();

		if (num < 0)
			digitCount--;

		int[] result = new int[digitCount];

		while (digitCount-- > 0) {
			result[digitCount] = num % 10;
			num /= 10;
		}
		return result;
	}

}
