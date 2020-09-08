package com.resende.codesignal;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	
	static final int[] ROW = {-1, -1, -1,  0, 0,  1, 1, 1};
	static final int[] COL = {-1,  0,  1, -1, 1, -1, 0, 1};
	
	
	public static void main(String[] args) {
		
		int[][] grid =  {
			{1, 1, 0, 0, 0},
			{0, 1, 0, 0, 1},
			{1, 0, 0, 1, 1},
			{0, 0, 0, 0, 1},
			{1, 0, 1, 0, 1}
		};
		
		System.out.println(countingIslandWithDfs(grid));
		System.out.println(countingIslandWithBfs(grid));
	}
	
	
	static boolean isSafe(int[][] grid, int m, int n, boolean[][] visited) {
		return m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && (grid[m][n] == 1 && !visited[m][n]);
	}
	
	static void dfs(int[][] grid, int m, int n, boolean[][] visited) {
		
		visited[m][n] = true;
		
		for (int k = 0; k < 8; k++) {
			if (isSafe(grid, m + ROW[k], n + COL[k], visited)){
				dfs(grid, m + ROW[k], n + COL[k], visited);
			}
		}
	}
	
	static int countingIslandWithDfs(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		int counter = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					dfs(grid, i, j, visited);
					counter++;
				}
			}
		}
		return counter;
	}
	
	
	static void bsf(int[][] grid, int m, int n, boolean[][] visited) {
		
		Queue<int[]>  queue = new LinkedList<int[]>();
		
		queue.add(new int[] {m, n});
		visited[m][n] = true;
		
		while (!queue.isEmpty()) {
			
			int[] mn = queue.poll();
			
			for(int k=0 ; k < 8; k++) {
				int r = mn[0] + ROW[k];
				int c = mn[1] + COL[k];
				if (isSafe(grid, r, c, visited)) {
					visited[r][c] = true;
					queue.add(new int[] {r, c});
				}
			}
		}
		
	}
	
	static int countingIslandWithBfs(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		int counter = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					bsf(grid, i, j, visited);
					counter++;
				}
			}
		}
		return counter;
	}
}
