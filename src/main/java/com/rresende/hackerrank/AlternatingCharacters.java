package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


public class AlternatingCharacters {
    
    
    @Test
    public void alternatingCharacters() {
        assertThat(alternatingCharacters("AAAA"), is(3));
        assertThat(alternatingCharacters("BBBBB"), is(4));
        assertThat(alternatingCharacters("ABABABAB"), is(0));
        assertThat(alternatingCharacters("AAABBB"), is(4));
    }

    
    static int alternatingCharacters(String s) {
        char chr = s.charAt(0);
        int c = 0;
        for (int i = 1; i < s.length(); i++) {
            if (chr == s.charAt(i)) {              
                c++;
                continue;
            } 
            chr = s.charAt(i);
        }
        return c;
    }
}
