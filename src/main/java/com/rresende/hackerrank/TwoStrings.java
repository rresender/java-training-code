package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.junit.Test;

public class TwoStrings {

    @Test
    public void twoStrings() {
        assertThat(twoStrings("hello", "world"), is("YES"));
        assertThat(twoStrings("hi", "world"), is("NO"));
        assertThat(twoStrings("beetroot", "sandals"), is("NO"));
    }

    static String twoStrings(String s1, String s2) {
        return Arrays.asList(s1.split("")).stream().distinct().collect(Collectors.joining())
                .concat(Arrays.asList(s2.split("")).stream().distinct().collect(Collectors.joining())).chars().boxed()
                .collect(Collectors.toMap(k -> Character.valueOf((char) k.intValue()), v -> 1, Integer::sum)).values()
                .stream().max(Comparator.naturalOrder()).get() > 1 ? "YES" : "NO";

    }

}
