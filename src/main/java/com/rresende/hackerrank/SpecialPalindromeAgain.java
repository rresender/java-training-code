package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpecialPalindromeAgain {

    @Test
    public void substrCount() {
        assertThat(substrCount(5, "asasd"), is(7L));
        assertThat(substrCount(5, "abcbaba"), is(10L));
        assertThat(substrCount(5, "aaaa"), is(10L));
    }

    static long substrCount(final int n, final String s) {
        final String[] ss = s.split("");
        int c = s.length();
        for (int i = 0; i < ss.length; i++) {
            String start = ss[i];
            int diff = -1;
            for (int j = i + 1; j < ss.length; j++) {
                String curr = ss[j];
                if (start.equals(curr)) {
                    if ((diff == -1) || (j - diff) == (diff - i)) {
                        c++;
                    }
                } else {
                    if (diff == -1) {
                        diff = j;
                        continue;
                    }
                    break;
                }
            }
        }
        return c;
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
