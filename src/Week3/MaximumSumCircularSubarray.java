/*
 * 918. Maximum Sum Circular Subarray
 * 
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * 
 * Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] 
 * when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 * 
 * Also, a subarray may only include each element of the fixed buffer A at most once.  
 * (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 * 
 * 	Example 1:
 * 		Input: [1,-2,3,-2]
 *		Output: 3
 *	Explanation: Subarray [3] has maximum sum 3
 *
 *	Example 2:
 *		Input: [5,-3,5]
 *		Output: 10
 *	Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 *
 *	Example 3:
 *		Input: [3,-1,2,-1]
 *		Output: 4
 *	Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 *
 *	Example 4:
 *		Input: [3,-2,2,-3]
 *		Output: 3
 *	Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 *
 *	Example 5:
 *		Input: [-2,-3,-1]
 *		Output: -1
 *	Explanation: Subarray [-1] has maximum sum -1
 *
 *	Note:
 *
 *		-30000 <= A[i] <= 30000
 *		1 <= A.length <= 30000
 * 
 * 
 * 
 * 
 */

package Week3;

import java.util.*;

public class MaximumSumCircularSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		int[] A = new int[st.countTokens()];
		int i = 0;
		while (st.hasMoreElements()) {
			A[i] = Integer.parseInt(st.nextElement().toString());
			i++;
		}
		System.out.println(maxSubarraySumCircular(A));
		scn.close();
	}

	public static int maxSubarraySumCircular(int[] A) {
		int noWrap = kadane(A);
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			A[i] = -A[i];
		}
		int wrap = kadane(A);
		if (wrap == -(sum)) {
			return noWrap;
		} else {
			wrap = sum + wrap;
			return Math.max(noWrap, wrap);

		}

	}

	public static int kadane(int[] A) {
		int maxSumSoFar = A[0];
		int currSum = A[0];
		for (int i = 1; i < A.length; i++) {
			currSum = Math.max(A[i], currSum + A[i]);
			maxSumSoFar = Math.max(currSum, maxSumSoFar);
		}
		return maxSumSoFar;
	}

}
