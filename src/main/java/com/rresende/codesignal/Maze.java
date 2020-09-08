package com.resende.codesignal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
	
	
	public static void main(String[] args) {
		
		int[][] maze = 
			{{1, 0, 0, 0},
			 {1, 1, 0, 1},
			 {0, 1, 0, 0},
			 {1, 1, 1, 1},
			};
		
		int[][] path1 = new int[maze.length][maze[0].length];
		
		System.out.println(solve(maze, 0, 0, 3, 2, path1));
		
		int[][] path2 = new int[maze.length][maze[0].length];
		System.out.println(solveBfs(maze, 0, 0, 3, 0, path2));
		
		System.out.println(Arrays.deepToString(path1).replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]").replaceAll("], ", "]\n"));
		System.out.println();
		System.out.println(Arrays.deepToString(path2).replaceAll("\\[\\[", "[").replaceAll("\\]\\]", "]").replaceAll("], ", "]\n"));
		
	}
	
	static boolean isSafe(int[][] maze, int m, int n) {
		return m >= 0 && m < maze.length && n >= 0 && n < maze[0].length && maze[m][n] == 1;
	}
	
	static boolean isSafe(int[][] maze, int m, int n, int[][] path) {
		return isSafe(maze, m, n) && path[m][n] == 0;
	}
	
	static boolean solve(int[][] maze, int m, int n, int x, int y, int[][] path) {
		
		if (m == x && n == y) {
			path[m][n] = 1;
			return true;
		}
		
		if (isSafe(maze, m, n) && path[m][n] == 0) {
			
			path[m][n] = 1;
			
			if (solve(maze, m+1, n, x, y, path)) {
				return true;
			}
			
			if (solve(maze, m-1, n, x, y, path)) {
				return true;
			}
			
			if (solve(maze, m, n+1, x, y, path)) {
				return true;
			}
			
			if (solve(maze, m, n-1, x, y, path)) {
				return true;
			}
		
			path[m][n] = 0;
			return false;
		}
		
		return false;
		
	}
	
	static boolean solveBfs(int[][] maze, int m, int n, int x, int y, int[][] path) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {m, n});
		
		while (!q.isEmpty()) {
			
			int[] cell = q.poll();
			
			int i = cell[0];
			int j = cell[1];

			path[i][j] = 1;
			
			if (i == x && j == y) {
				return true;
			}
			
			if (isSafe(maze, i + 1, j)) {
				q.add(new int[] {i + 1, j});
			} 
			
			if (isSafe(maze, i - 1, j)) {
				q.add(new int[] {i - 1, j});
			} 
			
			if (isSafe(maze, i, j + 1)) {
				q.add(new int[] {i, j + 1});
			}
			
			if (isSafe(maze, i, j - 1)) {
				q.add(new int[] {i, j - 1});
			}
			
		}
		
		return false;
		
	}

}
