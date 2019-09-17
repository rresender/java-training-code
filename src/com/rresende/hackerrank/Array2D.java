package com.rresende.hackerrank;
public class Array2D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int arr[][] = new int[6][6];
//		for (int arr_i = 0; arr_i < 6; arr_i++) {
//			for (int arr_j = 0; arr_j < 6; arr_j++) {
//				arr[arr_i][arr_j] = in.nextInt();
//			}
//		}
//		1 1 1 0 0 0
//		0 1 0 0 0 0
//		1 1 1 0 0 0
//		0 0 2 4 4 0
//		0 0 0 2 0 0
//		0 0 1 2 4 0
//		int arr[][] = new int[][]{{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}};
		
//		0 -4 -6 0 -7 -6
//		-1 -2 -6 -8 -3 -1
//		-8 -4 -2 -8 -8 -6
//		-3 -1 -2 -5 -7 -4
//		-3 -5 -3 -6 -6 -6
//		-3 -6 0 -8 -6 -7
		int arr[][] = new int[][]{{0,-4,-6,0,-7,-6},{-1,-2,-6,-8,-3,-1},{-8,-4,-2,-8,-8,-6},{-3,-1,-2,-5,-7,-4},{-3,-5,-3,-6,-6,-6},{-3,-6,0,-8,-6,-7}};
		for (int arr_i = 0; arr_i < 6; arr_i++) {
			for (int arr_j = 0; arr_j < 6; arr_j++) {
				System.out.print(arr[arr_i][arr_j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(calculate(arr));
	}

	private static int calculate(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int arr_i = 0; arr_i < 4; arr_i++) {
			for (int arr_j = 0; arr_j < 4; arr_j++) {
				int result = getHourGlasses(arr, arr_i, arr_j, 3);
				if (result > max) {
					max = result;
				}
			}
		}
		return max;
	}

	static int getHourGlasses(int[][] arr, int idx, int idy, int pattern) {
		System.out.println();
		int result = 0;
		for (int i = idx; i < pattern + idx; i++) {
			for (int j = idy; j < pattern + idy; j++) {
				if ((i == idx + 1 && j == idy) || (i == idx + 1 && j == idy + 2)) {
					System.out.print("  ");
					continue;
				}
				System.out.print(arr[i][j]+" ");
				result += arr[i][j];
			}
			System.out.println();
		}
		return result;
	}
}
