package com.rresende.codesignal;

import java.util.HashSet;
import java.util.Set;

public class Sudoku2 {
	
	boolean sudoku2(char[][] grid) {
	    int n = grid.length;
	    final Set<String> set = new HashSet<>();
	    for (int row = 0; row < n ; row++) {
	        for (int col = 0; col < n; col++) {
	            char c = grid[row][col];
				if (validate(set, c, c + " in row " + row)) 
					return false;
				if (validate(set, c, c + " in col " + col)) 
					return false;
	            if (validate(set, c, c + " in square " + row/3 + " " + col/3 )) 
	            	return false;
	        }
	    } 
	    return true;
	}

	private boolean validate(Set<String> set, char c,  String entry) {
		return c != '.' && !set.add(entry);
	}


}
