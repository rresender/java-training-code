package com.rresende.codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MininumMoves {

	public static void main(String[] args) {
		String[] grid = {"...", ".X.", "..." };
		System.out.println(minimumMoves(grid, 0, 0, 1, 2));
		
		String[] grid1 = {".X.", ".X.", "..." };
		System.out.println(minimumMoves(grid1, 0, 0, 1, 2));
	}
			
	static int minimumMoves(String[] grid, int m, int n, int x, int y) {
		
		final LinkedList<int[]> q = new LinkedList<>();
		
		int[][] distances = new int[grid.length][grid[0].length()];
		
		for (int i = 0; i < distances.length; i++) {
			Arrays.fill(distances[i], Integer.MAX_VALUE);
		}
		
		distances[m][n] = 0;
		q.offer(new int[] {m, n});
		
		while (!q.isEmpty()) {
			
			final int[] mn = q.poll();
			
			int currX = mn[0];
			int currY = mn[1];
			int d = distances[currX][currY];
			
			if (currX == x && currY == y) {
				return d;
			}
			
			final List<int[]> adjacents = new ArrayList<int[]>();
			
			int up = currX - 1;
			while( up >= 0 && grid[up].charAt(currY) != 'X') {
				adjacents.add(new int[]{up, currY});
				up--;
			}
			
			int down = currX + 1;
			while( down < grid.length && grid[down].charAt(currY) != 'X') {
				adjacents.add(new int[]{down, currY});
				down++;
			}
			
			int left = currY - 1;
			while( left >= 0 && grid[currX].charAt(left) != 'X') {
				adjacents.add(new int[]{currX, left});
				left--;
			}
			
			int right = currY + 1;
			while( right < grid[0].length() && grid[currX].charAt(right) != 'X') {
				adjacents.add(new int[]{currX, right});
				right++;
			}
			
			for (int[] cells : adjacents) {
				if ((d + 1) < distances[cells[0]][cells[1]]) {
					distances[cells[0]][cells[1]] = d + 1;
					q.add(cells);
				}
			}
		}
		
		return 0;
	}
}
