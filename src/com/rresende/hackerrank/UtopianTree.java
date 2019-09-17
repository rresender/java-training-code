package com.rresende.hackerrank;

import java.util.Scanner;

public class UtopianTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int a0 = 0; a0 < t; a0++) {
                int n = in.nextInt();
                if (n == 0) {
                    System.out.println(1);
                } else {
                    boolean summer = false;
                    int h = 1;
                    while (n-- > 0) {
                        if (!summer) {
                            h *= 2;
                            summer = true;
                        } else {
                            h += 1;
                            summer = false;
                        }
                    }
                    System.out.println(h);
                }
            }
        }
    }

}
