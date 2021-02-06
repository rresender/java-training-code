package com.rresende.hackerrank;

public class DownToZero {
	
	final static int[] MOVES = new int[1000001];
	
	public static int minMove(final int n) {
	    if (n <= 3) {
	    	return n;
	    }
	    if (MOVES[n] > 0) {
	    	return MOVES[n];
	    }
	    int min = Integer.MAX_VALUE;
	    for (int i = 2; i <= Math.sqrt(n); i++) {
	        if (n % i == 0) {
	            int f = n/i;
	            min = Math.min(min, 1 + minMove(f));
	        }
	    }
	    min = Math.min(min, 1 + minMove(n-1));
	    MOVES[n] = min;
	    return min;
	}

}
