package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class SherlockAndAnagrams {

    @Test
    public void sherlockAndAnagrams() {
        assertThat(sherlockAndAnagrams("abba"), is(4));
        assertThat(sherlockAndAnagrams("abcd"), is(0));
        assertThat(sherlockAndAnagrams("ifailuhkqq"), is(3));
        assertThat(sherlockAndAnagrams("kkkk"), is(10));
        assertThat(sherlockAndAnagrams("cdcd"), is(5));
        
    }

    static int sherlockAndAnagrams(String s) {
        String[] ss = s.split("");
        int c = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            String w = ss[i];
            list.add(w);
            for (int j = i+1; j < ss.length; j++) {
                list.add(sort(w+=ss[j]));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j= i+1; j < list.size(); j++) {
                String s1 = list.get(i);
                String s2 = list.get(j);
                if (s1.equals(s2)) {
                    c++;
                }
            }
        }
        return c;
    }
    
    static String sort(String s) {
        return s.chars().mapToObj(i -> Character.toString((char) i)).sorted().collect(Collectors.joining());
    }
}
