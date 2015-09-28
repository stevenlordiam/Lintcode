/*
Time: 	O(n+k)
Space:  O(n)

n: number of elements, k: range of input
*/

import java.util.*;

public class CountingSort {
	public static void countingSort(int[] arr){
		int max = arr[0], min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		
		int[] count = new int[max - min + 1];

		for(int number : arr){
			count[number - min]++;
		}

		int z = 0;
		for(int i = min; i <= max; i++) {
			while(count[i - min] > 0){
				arr[z]= i;
				z++;
				count[i - min]--;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {12, 0, 3, 7, 1, 5, 8, 2, 6, 9};
		countingSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}