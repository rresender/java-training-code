package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SherlockAndGCD {

    @Test
    public void sherlockAndGCD() {
        assertThat(sherlockAndGCD(new int[] { 1, 2, 3 }), is("YES"));
        assertThat(sherlockAndGCD(new int[] { 2, 4 }), is("NO"));
        assertThat(sherlockAndGCD(new int[] { 5, 5, 5 }), is("NO"));
        assertThat(sherlockAndGCD(new int[] {76050, 76050, 76050, 76050, 76050, 76050}), is("NO"));
        assertThat(sherlockAndGCD(new int[] {1710, 7414, 7706, 10037, 10303, 14259, 28775, 56600, 57758, 66694, 73054, 76927, 88458, 92544}), is("YES"));
        assertThat(sherlockAndGCD(new int[] {60437}), is("NO"));
        assertThat(sherlockAndGCD(new int[] {60437, 60437}), is("NO"));
        assertThat(sherlockAndGCD(new int[] {97706, 48853}), is("NO"));
        assertThat(sherlockAndGCD(new int[] {267, 12089, 15134, 16273, 19154, 20290, 22208, 22459, 23496, 30333, 32165, 33984, 46361, 47847, 49444, 56777, 58158, 71704, 74185, 84983, 85770, 88097, 88254, 98369}), is("YES"));
        assertThat(sherlockAndGCD(new int[] {2310, 2730, 4290, 6006, 10010, 11550, 13650, 15015, 21450, 50050, 57750, 68250, 75075}), is("YES"));
    }
    
    static String sherlockAndGCD(int[] set) {
        int i = 0;
        for (int e : set) {
            i = gcd(e, i);
        }
        return i >= 2 ? "NO" : "YES";
    }
   
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}