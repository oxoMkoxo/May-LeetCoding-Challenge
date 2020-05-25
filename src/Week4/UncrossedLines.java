/*
 * 1035. Uncrossed Lines
 * 
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 * 
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 * 		A[i] == B[j];
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 * 
 * Return the maximum number of connecting lines we can draw in this way.
 * 
 * 	Example 1:
 * 		Input: A = [1,4,2], B = [1,2,4]
 * 		Output: 2
 * 	Explanation: We can draw 2 uncrossed lines as in the diagram.
 * 				 We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line 
 * 				 from A[2]=2 to B[1]=2.
 * 
 * 	Example 2:
 * 		Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * 		Output: 3
 * 
 *  
 * 	Example 3:
 * 		Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * 		Output: 2
 * 
 * 	Note:
 * 		1 <= A.length <= 500
 * 		1 <= B.length <= 500
 * 		1 <= A[i], B[i] <= 2000 
 * 
 * 
 */

package Week4;

import java.util.Scanner;
import java.util.StringTokenizer;

public class UncrossedLines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String t = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		StringTokenizer st2 = new StringTokenizer(t, "[\\[\\],]");
		int[] A = new int[st.countTokens()];
		int[] B = new int[st2.countTokens()];

		int i = 0;
		while (st.hasMoreElements()) {
			A[i] = Integer.parseInt(st.nextElement().toString());
			i++;
		}
		i = 0;
		while (st2.hasMoreElements()) {
			B[i] = Integer.parseInt(st2.nextElement().toString());
			i++;
		}
//		for (i = 0; i < trust.length; i++) {
//			for (int j = 0; j < trust[i].length; j++) {
//				System.out.print(trust[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(maxUncrossedLines(A, B));
		scn.close();
	}

	public static int maxUncrossedLines(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
					continue;
				}
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[A.length][B.length];
	}
}
