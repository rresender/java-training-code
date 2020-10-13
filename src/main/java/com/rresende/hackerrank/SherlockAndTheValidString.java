package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Test;

public class SherlockAndTheValidString {

    @Test
    public void twoStrings() {
        assertThat(isValid("aabbcd"), is("NO"));
        assertThat(isValid("aabbccddeefghi"), is("NO"));
        assertThat(isValid("abcdefghhgfedecba"), is("YES"));
    }

    static String isValid(String s) {

        Map<Character, Integer> f = s.chars().boxed()
                .collect(Collectors.toMap(k -> Character.valueOf((char) k.intValue()), v -> 1,
                        Integer::sum));
            
        Map<Integer, Integer> count = f.values().stream().collect(Collectors.toMap(k -> k, v -> 1,
                Integer::sum));
        
        if (count.size() == 1) {
            return "YES";
        }

        Set<Entry<Character, Integer>> entrySet = f.entrySet();
      
        Iterator<Entry<Character, Integer>> iterator = entrySet.iterator();
        Entry<Character, Integer> first = iterator.next();
        
        Character key = null;
        while (iterator.hasNext()) {
            Entry<Character, Integer> next = iterator.next();
            if (first.getValue() == next.getValue()) {
                continue;
            }
            key = next.getKey();
            if (count.get(first.getValue()) < count.get(next.getValue()))
                key = first.getKey();
            break;
        }
        
        if (key == null) {
            return "YES";
        }
        
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(sb.lastIndexOf(key.toString()));
        
        s = sb.toString();
        
        f = s.chars().boxed().collect(Collectors.toMap(k -> Character.valueOf((char) k.intValue()), v -> 1, Integer::sum));
        
        TreeSet<Integer> c = new TreeSet<>(f.values());
        
        if (c.size() > 1) {
            return "NO";
        }
        
        return "YES";
    }

}
