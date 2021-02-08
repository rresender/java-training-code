package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class MakingAnagrams {

    @Test
    public void makingAnagrams() {
        assertThat(numberNeeded("cde", "abc"), is(4));
        assertThat(numberNeeded("bacdc", "bacdc"), is(0));
        assertThat(numberNeeded("bacdc", "dcbad"), is(2));
        assertThat(numberNeeded("aaabb", "aabbb"), is(2));
        assertThat(numberNeeded("aabb", "aaabbb"), is(2));
        assertThat(numberNeeded("ksmfgsxamduovigbasjchnoskolfwjhgetnmnkmcphqmpwnrrwtymjtwxget", "fsqoiaidfaukvngpsugszsnseskicpejjvytviya"), is(42));
        assertThat(numberNeeded("fsqoiaidfaukvngpsugszsnseskicpejjvytviya", "ksmfgsxamduovigbasjchnoskolfwjhgetnmnkmcphqmpwnrrwtymjtwxget"), is(42));
    }
    
    static int numberNeeded(String s1, String s2) {
        int c = 0;
        Map<Character, Integer> m1 = count(s1);
        Map<Character, Integer> m2 = count(s2);
        Set<Character> keys = new HashSet<>(m1.keySet());
        keys.addAll(m2.keySet());
        for (Character k : keys) {
            Integer v1 = m1.get(k) == null ? 0 : m1.get(k);
            Integer v2 = m2.get(k) == null ? 0 : m2.get(k);
            c+=Math.abs(v1-v2);
        }
        return c; 
    }

    static Map<Character, Integer> count(String a) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char k = a.charAt(i);
            Integer v = m.get(k);
            if (v == null)
                v = 0;
            m.put(k, ++v);
        }
        return m;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
