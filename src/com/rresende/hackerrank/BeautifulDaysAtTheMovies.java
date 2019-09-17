package com.rresende.hackerrank;

import java.util.Scanner;

public class BeautifulDaysAtTheMovies {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long i = in.nextLong();
            long j = in.nextLong();
            long k = in.nextLong();

            int c = 0;
            while (i < j) {
                long e = Math.abs(i - reverse(i));
                if (e % k == 0) {
                    c++;
                }

                i++;
            }

            System.out.println(c);
        }
    }

    static long reverse(long num) {
        StringBuilder b = new StringBuilder(String.valueOf(num));
        return Long.valueOf(b.reverse().toString());
    }

}
