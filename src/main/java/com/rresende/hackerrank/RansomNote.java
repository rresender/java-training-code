package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class RansomNote {

    @Test
    public void ransomNote() {
        assertThat(ransomNote("give me one grand today night", "give one grand today"), is("Yes"));
        assertThat(ransomNote("two times three is not four", "two times two is four"), is("No"));
    }
    
    private String ransomNote(String magazine, String note) {
        Map<String, Integer> magazineMap = fillMap(magazine);
        Map<String, Integer> noteMap = fillMap(note);
        Set<Entry<String, Integer>> entrySet = noteMap.entrySet();
        for (Entry<String, Integer> e : entrySet) {
            Integer v = magazineMap.get(e.getKey());
            if (v == null)
                return "No";
            if (v < e.getValue())
                return "No";
            magazineMap.put(e.getKey(), --v);
        }
        
        return "Yes";
    }

    private Map<String, Integer> fillMap(String magazine) {
        Map<String, Integer> magazineMap = new HashMap<>();
        String[] m = magazine.split(" ");
        for (String k : m) {
            Integer v = magazineMap.get(k);
            if (v == null)
                v = 0;
            magazineMap.put(k, ++v);
        }
        return magazineMap;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
