package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class CutTheSticks {

    @Test
    public void cutTheSticks() {
        assertThat(cutSticks(2, 5, 4, 4, 2, 2, 8), is(Arrays.asList(new Integer[] {6, 4, 2, 1})));
        assertThat(cutSticks(1, 1, 2, 3, 4, 3, 3, 2, 1), is(Arrays.asList(new Integer[] {8, 6, 4, 1})));
    }

    static List<Integer> cutSticks(int min, Integer...sticks) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < sticks.length; i++) {
            for (int j = 0; j < sticks.length; j++) {
                if (sticks[j] == Integer.MAX_VALUE)
                    continue;
                int minus = sticks[j] - min;
                if (minus == 0) {
                    sticks[j] = Integer.MAX_VALUE;
                } else {
                    sticks[j] = minus;
                }
                count++;
            }
            if (count != 0)
                result.add(count);
            Arrays.sort(sticks);
            min = sticks[0];
            count = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer sticks[] = new Integer[n];
        int min = Integer.MAX_VALUE;
        for(int arr_i=0; arr_i < n; arr_i++){
            sticks[arr_i] = in.nextInt();
            if (sticks[arr_i] < min) {
                min = sticks[arr_i];
            }
        }
        for (Integer e : cutSticks(min, sticks))
            System.out.println(e);
        in.close();
    }

    
}
