package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class FibonacciNumbers {

    @Test
    public void fibonacciNumbers() {
        assertThat(fibonacciNumber(0), is(0));
        assertThat(fibonacciNumber(1), is(1));
        assertThat(fibonacciNumber(2), is(1));
        assertThat(fibonacciNumber(3), is(2));
        assertThat(fibonacciNumber(6), is(8));
    }
    
    static int fibonacciNumber(int k) {
        if (k == 0)
            return k;
        if (k == 1)
            return k;
        return fibonacciNumber(k-1) + fibonacciNumber(k-2);  
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
