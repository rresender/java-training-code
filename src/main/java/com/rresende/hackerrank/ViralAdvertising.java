package com.rresende.hackerrank;

import java.util.Scanner;

public class ViralAdvertising {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            long d = in.nextLong();

            long sum = 0;
            long f = 5;
            while (d-- > 0) {
                long v = Double.valueOf(Math.floor(f / 2)).longValue();
                sum += v;
                f = v * 3;
            }

            System.out.println(sum);
        }

    }

}
