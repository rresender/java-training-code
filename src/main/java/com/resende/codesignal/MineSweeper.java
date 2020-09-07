package com.resende.codesignal;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class MineSweeper {

	static LinkedList<int[]> positions = new LinkedList<>();
	
	static int[][] buildBoard(int n, int m, int mines){
		
		generateMines(m, n);
		
		boolean[][] grid = new boolean[n][m];
		
		while (mines-- > 0) {
			int[] pos = positions.poll();			
			grid[pos[0]][pos[1]] = true;
		}

		for(int i=0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		
		int[][] counts = new int[n][m]; 
		
		for (int i=0; i < n; i++) {
			for (int j=0; j<m; j++ ) {
				if (!grid[i][j]) {
					
					//down
					if (i+1 < n && grid[i+1][j]) {
						counts[i][j]++;
					}
					//up
					if (i-1 >=0 && grid[i-1][j]) {
						counts[i][j]++;
					}
					//left
					if (j-1 >= 0 && grid[i][j-1]) {
						counts[i][j]++;
					}
					
					//right
					if (j+1 < m && grid[i][j+1]) {
						counts[i][j]++;
					}
					
					//up left
					if (i-1 >= 0 && j-1 >= 0 && grid[i-1][j-1]) {
						counts[i][j]++;
					}
					
					//up right
					if (i-1 >= 0 && j+1 < m && grid[i-1][j+1]) {
						counts[i][j]++;
					}
					
					//down left
					if (i+1 < n && j-1 >= 0 && grid[i+1][j-1]) {
						counts[i][j]++;
					}
					
					//up left
					if (i+1 < n && j+1 < n && grid[i+1][j+1]) {
						counts[i][j]++;
					}	
				}
			}
		}
		
		return counts;
	}
	
	static void generateMines(int m, int n) {
		for (int i=0; i < m; i++) {
			for (int j=0; j < n; j++) {
				positions.add(new int[] {i, j});
			}
		}
		Collections.shuffle(positions);
	}

	
		
	public static void main(String[] args) {
		int[][] board = buildBoard(10, 10, 1);
		for(int i=0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}

}
