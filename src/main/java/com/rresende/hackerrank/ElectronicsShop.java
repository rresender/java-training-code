package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class ElectronicsShop {

    @Test
    public void moneySpent() {
        assertThat(getMoneySpent(new int[] {3, 1}, new int[] {5, 2, 8}, 10), is(9));
        assertThat(getMoneySpent(new int[] {4}, new int[] {5}, 5), is(-1));
        assertThat(getMoneySpent(new int[] {3, 1}, new int[] {5, 2, 8}, 7), is(6));
    }

    int getMoneySpent(final int[] keyboards, final int[] drives, final int s){
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        int moneySpent = -1;
        for (int k = keyboards.length-1; k >= 0; k--) {
            for (int d = drives.length-1; d >= 0; d--) {
                final int sum = keyboards[k] + drives[d];
                if (sum <= s && sum > moneySpent)
                    moneySpent = sum;
            }
        }
        return moneySpent;
    }

}
