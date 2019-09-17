package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SequenceEquation {

    @Test
    public void sequenceEquations() {
        assertThat(sequenceEquations(new int[] { 2, 3, 1 }), is(Arrays.asList(new Integer[] { 2, 3, 1 })));
        assertThat(sequenceEquations(new int[] { 2, 1 }), is(Arrays.asList(new Integer[] { 1, 2 })));
        assertThat(sequenceEquations(new int[] { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 }),
                is(Arrays.asList(new Integer[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 1 })));
    }

    static List<Integer> sequenceEquations(int[] sequence) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = sequence.length - 1; i >= 0; i--) {
            map.put(sequence[i], i + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int x = 1; x <= sequence.length; x++) {
            for (int y = 1; y <= sequence.length; y++) {
                Integer ppy = map.get(map.get(y));
                if (map.get(x) == ppy) {
                    list.add(map.get(ppy));
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) throws Exception {

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        new BufferedWriter(new OutputStreamWriter(System.out));

        final int n = Integer.parseInt(reader.readLine());
        final int[] sequence = new int[n];

        final String[] sSequence = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            sequence[i] = Integer.parseInt(sSequence[i]);

        for (Integer i : sequenceEquations(sequence))
            System.out.println(i);
    }

}
