package com.rresende.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class StringTokens {

    @Test
    public void lonelyInteger() {
        String s = "Its always better if you find edge cases by yourself rather than buying test cases with valuable hackos!!   May be this case won't help you to find the   buuuuuug  ";
        List<String> c = Arrays.asList(s.split(" |,|'|\\!|\\?|\\.|\\_|\\@")).stream().filter(el-> el != null && !el.toString().trim().isEmpty()).collect(Collectors.toList());
        System.out.println(c.size());
        for (String e : c) {
            System.out.println(e);
        }
    }
}
