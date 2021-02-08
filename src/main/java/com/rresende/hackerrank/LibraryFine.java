package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class LibraryFine {

    @Test
    public void libraryFines() {
        assertThat(calculateLibraryFine(9, 6, 2015, 6, 6, 2015),is(45));
        assertThat(calculateLibraryFine(6, 6, 2015, 6, 6, 2015),is(0));
        assertThat(calculateLibraryFine(6, 6, 2015, 6, 6, 2014),is(10000));
        assertThat(calculateLibraryFine(9, 6, 2015, 6, 6, 2016),is(0));
        assertThat(calculateLibraryFine(31, 8, 2004, 20, 1, 2004),is(3500));
        assertThat(calculateLibraryFine(5, 5, 2014, 23, 2, 2014),is(1500));
    }

    static Integer calculateLibraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        Calendar c1 = new GregorianCalendar(y1, m1, d1);
        Calendar c2 = new GregorianCalendar(y2, m2, d2);
        if (y1 > y2)
            return 10000;
        if (y1 == y2 && m1 > m2)
            return 500 * Math.abs(m1 - m2);
        if (y1 == y2 && m1 == m2 && d1 > d2)     
            return 15 * Math.abs((c1.get(Calendar.DAY_OF_YEAR)-c2.get(Calendar.DAY_OF_YEAR)));
        return 0;
    }

    
}
