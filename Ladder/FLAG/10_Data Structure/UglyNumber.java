/*
Ugly number is a number that only have factors 3, 5 and 7.

Design an algorithm to find the Kth ugly number. The first 5 ugly numbers are 3, 5, 7, 9, 15 ...

Have you met this question in a real interview? Yes
Example
If K=4, return 9.

Challenge
O(K log K) or O(K) time
*/

public class Solution {
    public long kthPrimeNumber(int k) {
		if (k < 0) {
			return 1;// 把第一个丑数返回
		}
		long[] numbers = new long[k+1]; 	// use long to handle overflow
		numbers[0] = 1;
		int next = 1;
		int ugly3Index = 0;
		int ugly5Index = 0;
		int ugly7Index = 0;
		
		while (next <= k) {
			long uglyNum = Math.min(numbers[ugly3Index] * 3,
					Math.min(numbers[ugly5Index] * 5, numbers[ugly7Index] * 7));
			numbers[next] = uglyNum;
			while (numbers[ugly3Index] * 3 <= numbers[next]) {
				ugly3Index++;
			}
			while (numbers[ugly5Index] * 5 <= numbers[next]) {
				ugly5Index++;
			}
			while (numbers[ugly7Index] * 7 <= numbers[next]) {
				ugly7Index++;
			}
			next++;
		}
		return numbers[k];// 从0开始
	}
}

/*
http://blog.csdn.net/nisxiya/article/details/46767595
http://blog.csdn.net/martin_liang/article/details/45692933
http://blog.csdn.net/u010786672/article/details/44259927
*/