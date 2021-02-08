package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class CommonChild {

    @Test
    public void commonChild() {
        assertThat(commonChild("ABCD", "ABDC"), is(3));
        assertThat(commonChild("HARRY", "SALLY"), is(2));
        assertThat(commonChild("AA", "BB"), is(0));
        assertThat(commonChild("SHINCHAN", "NOHARAAA"), is(3));
        assertThat(commonChild("ABCDEF", "FBDAMN"), is(2));
    }

    static int commonChild(String s1, String s2) {
        final int[][] C = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    C[i + 1][j + 1] = C[i][j] + 1;
                    continue;
                }
                C[i + 1][j + 1] = Math.max(C[i + 1][j], C[i][j + 1]);
            }
        }
        return C[s1.length()][s2.length()];
    }

}
