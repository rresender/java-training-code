package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CountTriplets {

    @Test
    public void countTriplets() {
        assertThat(countTriplets(Arrays.asList(new Long[] { 1l, 2l, 2l, 4l }), 2), is(2L));
         assertThat(countTriplets(Arrays.asList(new Long[] { 1l, 3l, 9l, 9l, 27l, 81l}), 3), is(6L));
         assertThat(countTriplets(Arrays.asList(new Long[] { 1l, 5l, 5l, 25l, 125l }), 5), is(4L));
         assertThat(countTriplets(Arrays.asList(new Long[] {1l, 1l, 1l, 1l, 1l, 1l,
         1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l,
         1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l,
         1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l,
         1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l,
         1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l, 1l,}),
         1), is(161700L));

    }
  
    static long countTriplets(List<Long> a, long r) {
        long c = 0;
        final Map<Long, Long> d = new HashMap<>();
        final Map<Long, Long> dp = new HashMap<>();
        Collections.reverse(a);
        for (Long e : a) {
            final long p = e*r;
            if (dp.containsKey(p))
                c+=dp.get(p);
            if (d.containsKey(p))
                dp.put(e, dp.getOrDefault(e, 0L) + d.get(p));
            d.put(e, d.getOrDefault(e, 0L) + 1);
        }
        return c;
    }
}
