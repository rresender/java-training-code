package com.rresende.codesignal;

public class BinarySearch {
	
	static int search(int[] arr, int low, int fast, int key) {
		if (low <= fast)  {
			int mid = low + (fast - low) / 2;
			if (arr[mid] ==  key) {
				return mid;
			}
			if (arr[mid] > key) {
				return search(arr, low, mid-1, key);
			}
			return search(arr, mid+1, fast, key);
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6};
		System.out.println(search(arr, 0, arr.length-1, 6));
	}

}
