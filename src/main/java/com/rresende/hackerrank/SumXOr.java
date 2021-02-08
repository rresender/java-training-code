package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class SumXOr {

    @Test
    public void sumXor() {
        assertThat(sumXor(0L), is(1L));
        assertThat(sumXor(5L), is(2L));
        assertThat(sumXor(10L), is(4L));
        assertThat(sumXor(1000000000000000L), is(1073741824L));
    }

    private long sumXor(long n) {
        long result = 64 - Long.numberOfLeadingZeros(n) - Long.bitCount(n);
        return (long)Math.pow(2,result);
    }

    static int add(int i, int j) {
        int uncommonBitsFromBoth = i ^ j;
        int commonBitsFromBoth = i & j;
        if (commonBitsFromBoth == 0)
            return 1;
        return add(uncommonBitsFromBoth, commonBitsFromBoth << 1) + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(add(5, 4));
    }

}
