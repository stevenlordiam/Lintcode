public class BinarySearch {

	public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;  
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
	
	public static int binarySearchRecursive(int[] a, int x, int low, int high) {
		if (low > high) return -1; // Error
		
		int mid = (low + high) / 2;
		if (a[mid] < x) {
			return binarySearchRecursive(a, x, mid + 1, high);
		} else if (a[mid] > x) {
			return binarySearchRecursive(a, x, low, mid - 1);
		} else {
			return mid;
		}
	}		
	
	public static void main(String[] args) {
		int[] array = {3, 6, 9, 12, 15, 18};
		int loc = binarySearch(array, 9);
		int loc2 = binarySearchRecursive(array, 9, 0, array.length - 1);
		System.out.println(loc);
        System.out.println(loc2);
	}

}