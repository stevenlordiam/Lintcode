/*
Given a permutation which may contain repeated numbers, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Example
Given the permutation [1, 4, 2, 2], return 3
*/

public class Solution {
    long fac(int numerator) {
			
		long now = 1;
		for (int i = 1; i <= numerator; i++) {
			now *= (long) i;
		}
		return now;
	}

	long generateNum(HashMap<Integer, Integer> hash) {
		long denominator = 1;
		int sum = 0;
		for (int val : hash.values()) {
			if(val == 0 )	
				continue;
			denominator *= fac(val);
			sum += val;
		}
		if(sum==0) {
			return sum;
		}
		return fac(sum) / denominator;
	}

	public long permutationIndexII(int[] A) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (hash.containsKey(A[i]))
				hash.put(A[i], hash.get(A[i]) + 1);
			else {
				hash.put(A[i], 1);
			}
		}
		long ans = 0;
		for (int i = 0; i < A.length; i++) {
			HashMap<Integer, Integer> flag = new HashMap<Integer, Integer>();
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] < A[i] && !flag.containsKey(A[j])) {
				    	flag.put(A[j], 1);
				
					hash.put(A[j], hash.get(A[j])-1);
					ans += generateNum(hash);
					hash.put(A[j], hash.get(A[j])+1);
					
				}
			
			}
				hash.put(A[i], hash.get(A[i])-1);
		}
		return ans+1;
	}
}

/*
Reference:
http://www.jiuzhang.com/solutions/permutation-index-ii/
http://algorithm.yuanbin.me/exhaustive_search/permutation_index_ii.html
http://blog.csdn.net/earthma/article/details/47074779
*/