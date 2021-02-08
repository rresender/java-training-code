package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class FlippingBits {
    
    
    @Test
    public void flippingBits() {
        assertThat(flippingBits(4L), is(4294967291L));
        assertThat(flippingBits(123456L), is(4294843839L));
        assertThat(flippingBits(123456L), is(4294843839L));
        assertThat(flippingBits(0L), is(4294967295L));
        assertThat(flippingBits(802743475L), is(3492223820L));
        assertThat(flippingBits(35601423L), is(4259365872L));
    }

    static long flippingBits(long n) {
        return ~n & 0xFFFFFFFFL;
    }

}
