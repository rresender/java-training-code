package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Primality {

    @Test
    public void arraysLeftRotation() {
        assertThat(isPrime(1), is(false));
        assertThat(isPrime(9), is(false));
        assertThat(isPrime(1000000007), is(true));
        assertThat(isPrime(23), is(true));
    }
    
    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2, m = (int)Math.sqrt(n); i <= m; i++) {
            if (n % i == 0) {
                return false;   
            }
        }
        return true;
    }
    
}
