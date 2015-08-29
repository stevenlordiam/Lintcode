import java.util.*;

public class InsertionSort {	 		 
	public static void insertionSort(int array[]) {
		int n = array.length;
		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j-1;
			while ( (i > -1) && ( array [i] > key ) ) {
				array [i+1] = array [i];
				i--;
			}
			array[i+1] = key;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 2, 9, 6, 23, 12, 34, 0, 1 };
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}