/*
Best:    O(n log n)
Average: O(n log n)
Worst:   O(n log n)
*/

import java.util.*;

public class MergeSort {	
	public static void mergesort(int[] array) {
		mergesort(array, 0, array.length - 1);
	}

	public static void mergesort(int[] array, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, low, middle); // Sort left half
			mergesort(array, middle+1, high); // Sort right half
			merge(array, low, middle, high); // Merge them
		}
	}

	public static void merge(int[] array, int low, int middle, int high) {
		// Copy both halves into a helper array, remember: cannot simply do "helper = array"
		int[] helper = new int[array.length]; 
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		// Iterate through helper array. Compare the left and right half, copying back the smaller element from the two halves into the original array
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { // If right element is smaller than left element
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		// Copy the rest of the left side of the array into the target array
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}
	
	public static void main(String[] args) {
		int[] array = {5,3,6,1,7,2,4,9,8,0};
		System.out.println(Arrays.toString(array));
		mergesort(array);
		System.out.println(Arrays.toString(array));
	}
}

// https://youtu.be/EeQ8pwjQxTM