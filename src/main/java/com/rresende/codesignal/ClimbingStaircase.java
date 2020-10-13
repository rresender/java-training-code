package com.rresende.codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingStaircase {
	
	static void waysToReachN(int currentValue, int n, int k, List<Integer> pathSoFar, List<int[]> path) {
	    if(currentValue == n) {
	        path.add(pathSoFar.stream().mapToInt(e -> e).toArray());  
	        return;
	    } else if(currentValue > n) {
	        return;
	    }
	    for(int i = 1 ; i <= k ; i++) {
	        pathSoFar.add(i);
	        waysToReachN(currentValue + i, n, k, pathSoFar, path);
	        pathSoFar.remove(pathSoFar.size()-1);
	    }
	}

	
	public static void main(String[] args) {
//		System.out.println(climbingStaircase(0));
//		System.out.println(climbingStaircase(1));
//		System.out.println(climbingStaircase(2));
//		System.out.println(climbingStaircase(3));
		ArrayList<int[]> ret = new ArrayList<int[]>();
		waysToReachN(0, 4, 2, new ArrayList<Integer>(), ret);
		int[][] array = ret.stream().toArray(int[][]::new);
		System.out.println(Arrays.deepToString(array));
//		System.out.println(climbingStaircase(5));
	}
}
