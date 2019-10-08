package com.rresende.hackerrank;
import java.util.Scanner;
import java.util.TreeSet;


public class MiniMaxSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)){
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            long d = in.nextLong();
            long e = in.nextLong();
            
            long sum = a + b + c + d + e;
            
            TreeSet<Long> r = new TreeSet<>();
            r.add(sum-a);
            r.add(sum-b);
            r.add(sum-c);
            r.add(sum-d);
            r.add(sum-e);
            
            System.out.println(r.first()+" "+r.last());
		}
	}

}
