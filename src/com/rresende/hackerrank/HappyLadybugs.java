package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

public class HappyLadybugs {
    
    @Test
    public void happyLadybugs() {
        assertThat(happyLadybugs("X_Y__X"), is("NO"));
        assertThat(happyLadybugs("RRRR"), is("YES"));
        assertThat(happyLadybugs("AABBC"), is("NO"));
        assertThat(happyLadybugs("AABBC_C"), is("YES"));
        assertThat(happyLadybugs("_"), is("YES"));
        assertThat(happyLadybugs("DD__FQ_QQF"), is("YES"));
        assertThat(happyLadybugs("AABCBC"), is("NO"));
        assertThat(happyLadybugs("_"), is("YES"));
        assertThat(happyLadybugs("RBRB"), is("NO"));
        assertThat(happyLadybugs("RRRR"), is("YES"));
        assertThat(happyLadybugs("BBB"), is("YES"));
        assertThat(happyLadybugs("BBB_"), is("YES"));
        assertThat(happyLadybugs("G"), is("NO"));
        assertThat(happyLadybugs("GR"), is("NO"));
        assertThat(happyLadybugs("_GR_"), is("NO"));
        assertThat(happyLadybugs("_R_G_"), is("NO"));
        assertThat(happyLadybugs("R_R_R"), is("YES"));
        assertThat(happyLadybugs("RRGGBBXX"), is("YES"));
        assertThat(happyLadybugs("RRGGBBXY"), is("NO"));
        assertThat(happyLadybugs("IIIAA"), is("YES"));
        
    }

    static String happyLadybugs(String b) {
        
        Map<Character, Long> frequency =
                b.chars()
                   .mapToObj(c -> (char)c)
                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        if (frequency.size() == 1 && frequency.values().iterator().next() > 1) {
            return "YES";
        }
        
        Long underscore = frequency.remove('_');
        
        TreeSet<Long> set = new TreeSet<>(frequency.values());
        
        if (underscore ==  null) {
            if (isAligned(b)) {
                return "YES";
            }
            return "NO";
        }
        
        if (frequency.isEmpty()) {
            return "YES";
        }
        
        if (set.first() > 1) {
            return "YES";
        }
         
        return "NO";
    }
    
    static boolean isAligned(String s) {
        if (s.length() == 1)
            return false;
        if (s.length() % 2 != 0) {
            if (s.charAt(0) != s.charAt(1)) {
                return false;
            }
            if (s.charAt(s.length()-1) != s.charAt(s.length()-2)) {
                return false;
            }
            return true;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i+=2) {
            char c1 = charArray[i];
            char c2 = charArray[i+1];
            if (c1 == c2)
                continue;
            return false;
        }
        return true;
    }
}
