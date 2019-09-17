package com.rresende.hackerrank;
import java.util.Scanner;

public class SaveThePrisoner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)){
    		int t = in.nextInt();
    
    		for (int i = 0; i < t; i++) {
    			int n = in.nextInt();
    			int m = in.nextInt();
    			int s = in.nextInt();
    
    			if ((m + s - 1) % n == 0)
    				System.out.println(n);
    			else
    				System.out.println((m + s - 1) % n);
    
    		}
		}
	}
}
