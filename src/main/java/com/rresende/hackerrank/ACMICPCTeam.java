package com.rresende.hackerrank;

import java.util.Scanner;


public class ACMICPCTeam {
 
    public static void main(String[] args) {
        
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            String topic[] = new String[n];
            for (int topic_i = 0; topic_i < n; topic_i++) {
                topic[topic_i] = in.next();
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < topic.length; i++) {
                char[] a = topic[i].toCharArray();
                for (int j = i + 1; j < topic.length; j++) {
                    int ic = 0;
                    char[] b = topic[j].toCharArray();
                    for (int k = 0; k < m; k++) {
                        if (a[k] == '1' || b[k] == '1') {
                            ic++;
                        }
                    }
                    if (ic > max) {
                        max = ic;
                    }
                }
            }

            int c = 0;
            for (int i = 0; i < topic.length; i++) {
                char[] a = topic[i].toCharArray();
                for (int j = i + 1; j < topic.length; j++) {
                    int ic = 0;
                    char[] b = topic[j].toCharArray();
                    for (int k = 0; k < m; k++) {
                        if (a[k] == '1' || b[k] == '1') {
                            ic++;
                        }
                    }
                    if (ic == max) {
                        c++;
                    }
                }
            }

            System.out.println(max);
            System.out.println(c);
        }
    }
}
