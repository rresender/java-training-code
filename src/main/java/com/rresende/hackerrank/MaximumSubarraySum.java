package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.TreeSet;

import org.junit.Test;

public class MaximumSubarraySum {
    
    @Test
    public void maximumSum() {
        assertThat(maximumSum(new long[] { 1, 2, 3 }, 2L), is(1L));
        assertThat(maximumSum(new long[] { 3, 3, 9, 9, 5 }, 7L), is(6L));
        assertThat(maximumSum(new long[] { 1, 5, 9 }, 5L), is(4L));
    }

    private long maximumSum(long[] a, Long m) {
        Long maxSoFar = (a[a.length - 1] + a[a.length - 2]) % m;
        maxSoFar = (maxSoFar > (a[0] % m)) ? maxSoFar : a[0] % m;
        a[0] %= m;
        for (Long i = 1L; i < a.length; i++) {
            int idx = i.intValue();
            long currentNumber = a[idx] % m;
            maxSoFar = maxSoFar > currentNumber ? maxSoFar : currentNumber;
            a[idx] = (currentNumber + a[idx - 1]) % m;
            maxSoFar = maxSoFar > a[idx] ? maxSoFar : a[idx];
        }

        if (m.equals(maxSoFar + 1) || a.length == 2) {
            return maxSoFar;
        }

        long previousNumber = a[0];
        TreeSet<Long> set = new TreeSet<>();
        set.add(previousNumber);

        for (Long i = 2L; i < a.length; i++) {
            Long currentNumber = a[i.intValue()];
            Long ceiling = set.ceiling(currentNumber);
            if (ceiling == null) {
                set.add(a[i.intValue() - 1]);
                continue;
            }

            if (ceiling.equals(currentNumber)) {
                set.remove(ceiling);
                Long greaterCeiling = set.ceiling(currentNumber);
                if (greaterCeiling == null) {
                    set.add(ceiling);
                    set.add(a[i.intValue() - 1]);
                    continue;
                }
                set.add(ceiling);
                ceiling = greaterCeiling;
            }
            Long newMax = (currentNumber - ceiling + m);
            maxSoFar = maxSoFar > newMax ? maxSoFar : newMax;
            set.add(a[i.intValue() - 1]);
        }

        return maxSoFar;

    }

    // static long maximumSum(long[] arr, long m) {
    // AtomicLong max = new AtomicLong(Long.MIN_VALUE);
    // subsetSums(arr, 0, arr.length - 1, 0, max, m);
    // return max.get();
    // }
    //
    // static void subsetSums(long[] arr, int l, long r, long sum, AtomicLong max,
    // long m) {
    // if (l > r) {
    // max.set(Math.max(max.get(), sum % m));
    // return;
    // }
    // subsetSums(arr, l + 1, r, sum + arr[l], max, m);
    // subsetSums(arr, l + 1, r, sum, max, m);
    // }
}
