/*
Cosine similarity is a measure of similarity between two vectors of an inner product space that measures the cosine of the angle between them. The cosine of 0° is 1, and it is less than 1 for any other angle

See wiki: Cosine Similarity (https://en.wikipedia.org/wiki/Cosine_similarity)

Given two vectors A and B with the same size, calculate the cosine similarity
Return 2.0000 if cosine similarity is invalid (for example A = [0] and B = [0])

Example
Given A = [1, 2, 3], B = [2, 3 ,4]
Return 0.9926

Given A = [0], B = [0]
Return 2.0000
*/

public class Solution {
	public double cosineSimilarity(int[] A, int[] B) {
		final double INVALID_RESULT = 2.0000; 
		double res;
		if(A.length != B.length) return INVALID_RESULT;
		double nA = absArray(A), nB = absArray(B), m = 0;
		if (nA == 0 || nB == 0) return INVALID_RESULT;
		for (int i = 0; i < A.length; i++) {
			m += A[i] * B[i];
		}
		return m / (nA * nB);
	}
		
	public double absArray(int[] arr) {
		double res = 0.0;
		for (int i = 0; i < arr.length; i++) {
			res += arr[i] * arr[i];
		}
		return Math.sqrt(res);
	}
}