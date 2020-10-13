package com.rresende.codesignal;

import java.util.Arrays;

public class Sorting {
	
	
	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		int i = (low -1);
		
		for(int j = low; j <= high-1; j++) {
			if(arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i+1, high);
		
		return i+1;
	}
	
	static void quickSort(int[] arr, int low, int high) {
		if( low < high) {
			int p = partition(arr, low, high);
			quickSort(arr, low, p - 1);
			quickSort(arr, p + 1, high);
		}		
	}
	
	static void merge(int[] arr, int l, int m, int r) {
		
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for (int i = 0; i < left.length; i++) {
			left[i] = arr[l+i];
		}
		
		
		for (int j = 0; j < right.length; j++) {
			right[j] = arr[m + 1 + j];
		}
		
		int i = 0, j = 0, k = l;
		
		while (i < n1 && j < n2) {
			
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while (j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
		
	}
	
	static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l+r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}
	
	static void heapfy(int[] arr, int n, int i) {
		
		System.out.println(Arrays.toString(arr));
		
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		
		if(right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if (largest != i) {
			
			int tmp = arr[i];
			arr[i] =  arr[largest];
			arr[largest] = tmp;
			
			heapfy(arr, n, largest);
		}
		
	}
	
	static void heapSort(int[] arr) {
		
		int n = arr.length;
		
		for (int i = n/2 - 1; i >= 0; i--) {
			heapfy(arr, n, i);
		}
		
		for (int i = n-1; i>=0; i--) {
			int tmp = arr[0];
			arr[0] =  arr[i];
			arr[i] = tmp;
			heapfy(arr, i, 0);
		}
		
	}
	
	public static void main(String[] args) {
//		int[] arr = {10, 80, 30, 90, 40, 50, 70};
		int[] arr = {38, 27, 43, 3, 9, 82, 10};
//		quickSort(arr, 0, arr.length-1);
//		mergeSort(arr, 0, arr.length-1);
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
