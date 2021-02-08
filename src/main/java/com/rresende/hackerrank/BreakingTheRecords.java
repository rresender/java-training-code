package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class BreakingTheRecords {

    @Test
    public void records() {
        assertThat(getRecords(), is(scores()));
        assertThat(getRecords(9), is(scores(0, 0)));
        assertThat(getRecords(9, 3), is(scores(0, 1)));
        assertThat(getRecords(9, 3, 10), is(scores(1, 1)));
        assertThat(getRecords(9, 3, 10, 2), is(scores(1, 2)));
        assertThat(getRecords(10, 5, 20, 20, 4, 5, 2, 25, 1), is(scores(2, 4)));
        assertThat(getRecords(3, 4, 21, 36, 10, 28, 35, 5, 24, 42), is(scores(4, 0)));
    }

    private int[] getRecords(int...scores) {
        if (scores.length == 0)
            return new int[]{};
        else if (scores.length == 1)
            return new int[]{0, 0};
        
        int highest = scores[0];
        int lowest = highest;
        int countLowest = 0;
        int countHighest = countLowest;
        
        for (int i = 1; i < scores.length; i++) {
            int s = scores[i];
            if (s > highest) {
                countHighest++;
                highest = s;
            }
            if (s < lowest) {
                countLowest++;
                lowest = s;
            }
        }
        return new int[]{countHighest, countLowest};       
    }
    
    private int[] scores(int...count) {
        return count;
    }
}
