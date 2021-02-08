package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class StrangeCounter {
    
    
    @Test
    public void happyLadybugs() {
//        assertThat(strangeCounter(4L), is(6L));
        assertThat(strangeCounter(17L), is(5L));
//        assertThat(strangeCounter(1000000000000L), is(649267441662L));
    }
    
    static long strangeCounter(long t) {
        long v = 3;
        long i = 1;
        while (t-i >= v) {
          i += v;
          v *= 2;
        }
        return v - (t - i);
    }

}
