package com.rresende.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            BigInteger inc = new BigInteger("1");
            BigInteger fact = new BigInteger("1");

            for (int c = 1; c <= n; c++) {
                fact = fact.multiply(inc);
                inc = inc.add(BigInteger.ONE);
            }
            System.out.println(fact);
        }
    }

}
