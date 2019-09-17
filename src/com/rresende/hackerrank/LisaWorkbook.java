package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LisaWorkbook {
    
    @Test
    public void workbook() {
        assertThat(workbook(5, 3, new int[] {4, 2, 6, 1, 10}), is(4));
        assertThat(workbook(10, 5, new int[] {3, 8, 15, 11, 14, 1, 9, 2, 24, 31}), is(8));
        assertThat(workbook(25, 10, new int[] {1, 29, 94, 15, 87, 100, 20, 55, 100, 45, 82, 80, 100, 100, 3, 53, 100, 2, 100, 100, 100, 100, 100, 100, 1}), is(11));
    }

    static int workbook(int n, int k, int[] arr) {
        int r = 0;
        int page = 1;
        for (int e : arr) {
            int problem = 1;
            int c = 0;
            while (problem <= e) {
                if (c == k) {
                    page++;
                    c = 0;
                } 
                if (problem == page) {
                    r++;
                }
                c++;
                problem++;
            }
            page++;
        }
        return r;
    }

}
