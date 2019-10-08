package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DrawingBook {

    @Test
    public void bookPages() {
       assertThat(getNumberOfPages(6, 2), is(1));
       assertThat(getNumberOfPages(5, 4), is(0));
       assertThat(getNumberOfPages(18183, 18042), is(70));
       assertThat(getNumberOfPages(6, 5), is(1));
       assertThat(getNumberOfPages(95073, 17440), is(8720));
       assertThat(getNumberOfPages(15600, 1560), is(780));
       assertThat(getNumberOfPages(4, 4), is(0));
       assertThat(getNumberOfPages(6, 4), is(1));
       assertThat(getNumberOfPages(6, 3), is(1));
       assertThat(getNumberOfPages(2, 1), is(0));
    }
       
    private Integer getNumberOfPages(int n, int p) {
        int minumumPages = 0;
        if (n == p)
            return minumumPages;
        int half = n / 2;
        if (p <= half) {
            minumumPages = p / 2;
        } else {
            minumumPages = n - p;
            if (minumumPages == 1 && n % 2 == 0)
                return minumumPages;
           minumumPages = minumumPages / 2;
        }
        return minumumPages;
    }

}
