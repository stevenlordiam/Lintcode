/*
Best: 	 O(n^2)
Average: O(n^2)
Worst:   O(n^2)
*/

import java.util.*;

public class SelectionSort {
	public static int[] selectionSort(int[] arr){
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;  // smallest number index
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[index])
					index = j;
	  
			int smallerNumber = arr[index]; 	// swap
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
		return arr;
	}
	 
	public static void main(String[] args){
		int[] arr = {10,34,2,56,7,67,88,42};
		System.out.println(Arrays.toString(selectionSort(arr)));
	}
}

// https://youtu.be/f8hXR_Hvybo