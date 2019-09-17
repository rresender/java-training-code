package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Abbreviation {

    @Test
    public void abbreviation() {
        assertThat(abbreviation("daBcd", "ABC"), is("YES"));
    }

    static String abbreviation(final String a, final String b) {
        final int m = a.length();
        final int n = b.length();

        final boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                if (!dp[i][j]) {
                    continue;
                }
                if (j < b.length() && Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
                    dp[i+1][j+1] = true;
                }
                
                if (Character.isLowerCase(a.charAt(i))){
                    dp[i+1][j] = true;
                }
            }
        }

        return dp[m][n] ? "YES" : "NO";
    }

}
