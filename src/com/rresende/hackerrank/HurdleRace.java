package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class HurdleRace {

    @Test
    public void magicBeverages() {
        assertThat(minimumNumberOfMagicBeverages(5, 4,  new int[] {1, 6, 3, 5, 2}), is(2));
        assertThat(minimumNumberOfMagicBeverages(5, 7,  new int[] {2, 5, 4, 5, 2}), is(0));
    }

    private Integer minimumNumberOfMagicBeverages(int beverages, int hurdles, int[] heights) {
        Arrays.sort(heights);
        int numberOfMagicBeverages = 0;
        for (int i = 0; i < heights.length; i++) {
            if (hurdles >= heights[i])
                continue;
            numberOfMagicBeverages = heights[i] - hurdles;
        }
        return numberOfMagicBeverages;
    }

}
