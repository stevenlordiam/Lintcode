/*
Best: 	 O(n)
Average: O(n^2)
Worst:   O(n^2)
*/

import java.util.*;

public class BubbleSort {
	public static int[] bubbleSort(int array[]) {
		int n = array.length;
		int k;
		for (int m = n; m >= 0; m--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (array[i] > array[k]) {
					swap(i, k, array);
				}
			}
		}
		return array;
	}
 
	public static void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		System.out.println(Arrays.toString(bubbleSort(arr))); 
	}
}

// https://youtu.be/8Kp-8OGwphY