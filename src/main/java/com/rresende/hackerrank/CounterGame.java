package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CounterGame {

    
    @Test
    public void alternatingCharacters() {
        assertThat(counterGame(6), is("Richard"));
        assertThat(counterGame(132), is("Louise"));
        assertThat(counterGame(1560834904), is("Richard"));
        assertThat(counterGame(1768820483), is("Richard"));
        assertThat(counterGame(1533726144), is("Louise"));
        assertThat(counterGame(1620434450), is("Richard"));
    }
    
    static String counterGame(long n) {
        return (Long.bitCount(n - 1) - 1 & 1) == 0 ? "Louise" : "Richard";
    }

   
}
