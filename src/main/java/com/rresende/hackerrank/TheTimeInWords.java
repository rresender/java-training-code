package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class TheTimeInWords {
    
    @Test
    public void theTimeInWords() {
        assertThat(theTimeInWords(5, 00), is("five o' clock"));
        assertThat(theTimeInWords(5, 01), is("one minute past five"));
        assertThat(theTimeInWords(5, 10), is("ten minutes past five"));
        assertThat(theTimeInWords(5, 13), is("thirteen minutes past five"));
        assertThat(theTimeInWords(5, 15), is("quarter past five"));
        assertThat(theTimeInWords(5, 17), is("seventeen minutes past five"));
        assertThat(theTimeInWords(5, 20), is("twenty minutes past five"));
        assertThat(theTimeInWords(5, 27), is("twenty seven minutes past five"));
        assertThat(theTimeInWords(5, 30), is("half past five"));
        assertThat(theTimeInWords(5, 34), is("twenty six minutes to six"));
        assertThat(theTimeInWords(5, 40), is("twenty minutes to six"));
        assertThat(theTimeInWords(5, 41), is("forty one minutes past five"));
        assertThat(theTimeInWords(5, 44), is("forty four minutes past five"));
        assertThat(theTimeInWords(5, 45), is("quarter to six"));
        assertThat(theTimeInWords(4, 47), is("thirteen minutes to five"));
        assertThat(theTimeInWords(6, 35), is("twenty five minutes to seven"));
        assertThat(theTimeInWords(4, 27), is("twenty seven minutes past four"));
    }
    
    private String theTimeInWords(int h, int m) {
        Map<Integer, String> timeMap = new HashMap<>();
        timeMap.put(0, "o' clock");
        timeMap.put(1, "one");
        timeMap.put(2, "two");
        timeMap.put(3, "three");
        timeMap.put(4, "four");
        timeMap.put(5, "five");
        timeMap.put(6, "six");
        timeMap.put(7, "seven");
        timeMap.put(8, "eight");
        timeMap.put(9, "nine");
        timeMap.put(10, "ten");
        timeMap.put(11, "eleven");
        timeMap.put(12, "twelve");
        timeMap.put(13, "thirteen");
        timeMap.put(14, "fourteen");
        timeMap.put(15, "quarter");
        timeMap.put(16, "sixteen");
        timeMap.put(17, "seventeen");
        timeMap.put(18, "eightteen");
        timeMap.put(19, "nineteen");
        timeMap.put(20, "twenty");
        timeMap.put(30, "half");
        timeMap.put(40, "twenty");
        timeMap.put(45, "quarter to");
        timeMap.put(50, "fifty");
        
        String sHour = timeMap.get(h);
        if (m == 0) {
            return sHour+" "+timeMap.get(m);
        }
        else if (m >= 1 && m <= 14) {
            String minute = "minute";
            if (m > 9)
                minute = "minutes";
            return timeMap.get(m)+" "+minute+" past "+sHour;
        }
        else if (m == 15) {
            return timeMap.get(m)+" past "+sHour;
        }
        else if (m >= 16 && m <= 29) {
            if (m <= 20) {
                return timeMap.get(m)+" minutes past "+sHour;
            } else {
                int mm = m % 20;
                m = (m / 10) * 10;
                return timeMap.get(m)+" "+timeMap.get(mm)+" minutes past "+sHour;
            }
        }
        else if (m == 30) {
            return timeMap.get(m)+" past "+sHour;
        }
        else if (m >= 31 && m <= 39) {
            m = 60-m;
            int mm = m % 20;
            m = (m / 10) * 10;
            return timeMap.get(60-m)+" "+timeMap.get(mm)+" minutes to "+timeMap.get(h+1);
        }
        else if (m == 40) {
            return timeMap.get(m)+" minutes to "+timeMap.get(h+1);
        }
        else if (m >= 41 && m <= 44) {
            int mm = m % 40;
            m = (m / 10) * 10;
            return "forty "+timeMap.get(mm)+" minutes past "+sHour;
        }
        else if (m == 45) {
            return timeMap.get(m)+" "+timeMap.get(h+1);
        }
        else {
            return timeMap.get(60-m)+" minutes to "+timeMap.get(h+1);
        }
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
