package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FormingMagicSquare {

    @Test
    public void magicSquares() {
        assertThat(formingMagicSquare(new int[][] {{4, 9, 2}, {3, 5, 7}, {8, 1, 5}}), is(1));
        assertThat(formingMagicSquare(new int[][] {{4, 8, 2}, {4, 5, 7}, {6, 1, 6}}), is(4));
    }
    
    private Integer formingMagicSquare(int[][] s) {
        List<int[][]> list = new ArrayList<>();
        int[][] s1 = new int[][] {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        list.add(s1);
        int[][] s2 = new int[][] {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        list.add(s2);
        int[][] s3 = new int[][] {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}};
        list.add(s3);
        int[][] s4 = new int[][] {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
        list.add(s4);
        int[][] s5 = new int[][] {{4, 9 ,2}, {3, 5, 7}, {8, 1, 6}};
        list.add(s5);
        int[][] s6 = new int[][] {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        list.add(s6);
        int[][] s7 = new int[][] {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};
        list.add(s7);
        int[][] s8 = new int[][] {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        list.add(s8);
        int[][] s9 = new int[][] {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}};
        list.add(s9);
        int min = Integer.MAX_VALUE;
        
        for (int[][] e : list) {
            int sum = 0;
            for (int i = 0; i < s.length; i++)
                for (int j = 0; j < s.length; j++)
                    sum+= Math.abs(s[i][j] - e[i][j]);
            if (sum < min)
                min = sum;
        }
        return min;
    }

}
