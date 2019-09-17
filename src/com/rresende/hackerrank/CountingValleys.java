package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CountingValleys {

    @Test
    public void countingValleys() {
        assertThat(countingValley(2, "UD"), is(0));
        assertThat(countingValley(8, "UDDDUDUU"), is(1));
        assertThat(countingValley(16, "UDDDUDUUUDDDUDUU"), is(2));
    }

    private int countingValley(int n, String upsAndDowns) {
        if (n <= 2)
            return 0;
        char[] upAndDown = upsAndDowns.toCharArray();
        int seaLevel = 0;
        boolean isInValley = false;
        int countValleys = 0;
        for (char c : upAndDown) {
            if (c == 'U')
                seaLevel++;
            else 
                seaLevel--;
            
            if (!isInValley && seaLevel < 0) {
                isInValley = true;
            }
            if (isInValley && seaLevel >= 0) {
                isInValley = false;
                countValleys++;
            }
        }
        return countValleys;
    }

}
