package com.rresende.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesignerPDFViewer {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            int n = 26;
            int h[] = new int[n];
            for (int h_i = 0; h_i < n; h_i++) {
                h[h_i] = in.nextInt();
            }

            String word = in.next();
            List<Character> al = new ArrayList<>();
            for (char c = 'a'; c <= 'z'; c++) {
                al.add(c);
            }

            char[] a = word.toCharArray();
            int max = Integer.MIN_VALUE;
            for (char c : a) {
                int v = h[al.indexOf(c)];
                if (v > max) {
                    max = v;
                }
            }
            int r = max * 1 * a.length;
            System.out.println(r);
        }
    }

}
