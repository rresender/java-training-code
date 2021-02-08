package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TheDayOfTheProgrammer {

    @Test
    public void daysOfTheProgrammer() {
        assertThat(dayOfTheProgrammer(null), is((String)null));
        assertThat(dayOfTheProgrammer(2017), is("13.09.2017"));
        assertThat(dayOfTheProgrammer(2016), is("12.09.2016"));
        assertThat(dayOfTheProgrammer(2015), is("13.09.2015"));
        assertThat(dayOfTheProgrammer(1917), is("13.09.1917"));
        assertThat(dayOfTheProgrammer(1919), is("13.09.1919"));
        assertThat(dayOfTheProgrammer(1700), is("12.09.1700"));
        assertThat(dayOfTheProgrammer(1900), is("12.09.1900"));
        assertThat(dayOfTheProgrammer(1800), is("12.09.1800"));
        assertThat(dayOfTheProgrammer(1918), is("26.09.1918"));
    }

    private String dayOfTheProgrammer(Integer year) {
        if (year == null)
            return null;        
        Calendar d = setDayOfProgrammer(year);
        return day(d)+"."+month(d) +"."+year(d);
    }

    private Calendar setDayOfProgrammer(Integer year) {
        Calendar d = setInitialDate(year);
        int days = 255;
        
        if (year == 1918)
            days+=13;
        else if (year <= 1900 && (year % 4 == 0) && (year % 100 == 0))
            days--;
        
        d.add(Calendar.DAY_OF_MONTH, days);
        
        return d;
    }

    private int year(Calendar d) {
        return d.get(Calendar.YEAR);
    }

    private int day(Calendar d) {
        return d.get(Calendar.DAY_OF_MONTH);
    }

    private String month(Calendar d) {
        int m = d.get(Calendar.MONTH)+1;
        return m < 10 ? "0"+m : ""+m;
    }

    private Calendar setInitialDate(Integer year) {
        Calendar d = GregorianCalendar.getInstance();
        d.set(Calendar.DAY_OF_MONTH, 1);
        d.set(Calendar.MONTH, Calendar.JANUARY);
        d.set(Calendar.YEAR, year);
        return d;
    }
}
