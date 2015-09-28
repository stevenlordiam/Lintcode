/*
Best: 	 O(n log n)
Average: O(n log n)
Worst:   O(n^2)
*/

import java.util.*;

public class Quicksort {
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static int partition(int arr[], int left, int right) {
		int pivot = arr[(left + right) / 2]; // Pick a pivot point. Can be an element.
		
		while (left <= right) { 	// Until we've gone through the whole array. Find element on left that should be on right
			while (arr[left] < pivot) { 
				left++;
			}
			while (arr[right] > pivot) {	// Find element on right that should be on left
				right--;
			}
			if (left <= right) {		// Swap elements, and move left and right indices
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left; 
	}
	
	public static void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right); 
		if (left < index - 1) { // Sort left half
			quickSort(arr, left, index - 1);
		}
		if (index < right) { // Sort right half
			quickSort(arr, index, right);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5,3,6,1,7,2,4,9,8,0};
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}

// https://youtu.be/aQiWF4E8flQ