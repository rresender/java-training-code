package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LuckBalance {

    @Test
    public void testLuckBalance() {
    	
    	assertThat(luckBalance(3, new int[][]{{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}}), is(29));
    	
    	assertThat(luckBalance(3, new int[][]{{105, 0},
    		{103, 0},
    		{106, 1},
    		{106, 1},
    		{103, 0},
    		{103, 1},
    		{105, 1},
    		{106, 1},
    		{105, 0},
    		{104, 0},
    		{103, 0},
    		{102, 0},
    		{104, 0},
    		{105, 0},
    		{104, 0},
    		{102, 1},
    		{104, 0},
    		{106, 1},
    		{104, 1},
    		{101, 1},
    		{105, 0},
    		{103, 0},
    		{104, 0},
    		{106, 0},
    		{102, 1},
    		{103, 0},
    		{102, 0},
    		{103, 1},
    		{106, 0},
    		{104, 1},
    		{101, 1},
    		{101, 1},
    		{106, 0},
    		{103, 1},
    		{103, 0},
    		{104, 1},
    		{101, 0},
    		{105, 1},
    		{105, 0},
    		{104, 1},
    		{105, 0},
    		{106, 0},
    		{104, 0},
    		{105, 0},
    		{101, 1},
    		{106, 1},
    		{105, 0},
    		{103, 0},
    		{104, 1},
    		{101, 1},
    		{106, 1},
    		{104, 0},
    		{106, 1},
    		{105, 0},
    		{103, 1},
    		{101, 0},
    		{103, 0},
    		{101, 0},
    		{105, 1},
    		{104, 1},
    		{104, 1},
    		{105, 1},
    		{105, 1},
    		{103, 0},
    		{101, 0},
    		{104, 1},
    		{106, 1},
    		{105, 1},
    		{105, 0},
    		{106, 1},
    		{104, 1},
    		{105, 1},
    		{103, 1},
    		{102, 1},
    		{106, 0},
    		{101, 0},
    		{105, 1},
    		{104, 1},
    		{103, 1},
    		{106, 1},
    		{101, 0},
    		{106, 1},
    		{103, 0},
    		{106, 1},
    		{102, 1},
    		{103, 0},
    		{101, 1},
    		{102, 1},
    		{101, 1},
    		{104, 0},
    		{106, 0},
    		{102, 0},
    		{104, 0},
    		{105, 0},
    		{105, 0},
    		{102, 1},
    		{103, 1}}), is(10069));
    	
    }
    
    static int luckBalance(int k, int[][] contests) {
    	Long luck = 0L;
    	Arrays.sort(contests, (int[] a, int[] b) -> {
    		if (a[0] > b[0] && a[1] == 1) {
    			return -1;
    		}
    		return 0;
		});
    	
    	
    	final List<Integer> tempList = new ArrayList<>();
    	
		for (int i = 0; i < contests.length; i++) {
			int[] temp = contests[i];
			int L = temp[0];
			int T = temp[1];
			if (T == 0) {
				luck += L;
			} else if (k > 0) {
				luck += L;
				k--;
			} else {
				tempList.add(L);
			}
		}
		
		for (Integer e : tempList) {
			luck-=e;
		}
    	return luck.intValue();
    }

}
