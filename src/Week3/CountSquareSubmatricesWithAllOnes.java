/*
 * 1277. Count Square Submatrices with All Ones
 * 
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * 
 * 	Example 1:
 * 		Input: matrix =
 * 			[
 * 			  [0,1,1,1],
 * 			  [1,1,1,1],
 * 			  [0,1,1,1]
 * 			]
 * 		Output: 15
 * 		Explanation:	
 * 			There are 10 squares of side 1.
 * 			There are 4 squares of side 2.
 * 			There is  1 square of side 3.
 * 			Total number of squares = 10 + 4 + 1 = 15.
 * 
 * 	Example 2:
 * 		Input: matrix = 
 * 			[
 * 			  [1,0,1],
 * 			  [1,1,0],
 * 			  [1,1,0]
 * 			]
 * 		Output: 7
 * 		Explanation: 
 * 			There are 6 squares of side 1.  
 * 			There is 1 square of side 2. 
 * 			Total number of squares = 6 + 1 = 7.
 * 
 * 	Constraints:
 * 		1 <= arr.length <= 300
 * 		1 <= arr[0].length <= 300
 * 		0 <= arr[i][j] <= 1
 * 
 * 
 */

package Week3;

import java.util.*;

public class CountSquareSubmatricesWithAllOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		StringTokenizer	brac = new StringTokenizer(s, "]");
		int row = brac.countTokens();
		int col = st.countTokens() / row;
		int[][] matrix = new int[row][col];
		int i = 0;
		int j = 0;
		while(st.hasMoreTokens()) {
			matrix[i][j++] = Integer.parseInt(st.nextToken());
			if(j >= col) {
				i++;
				j = 0;
			}
		}
//		for(int[] arr : matrix) {
//			for(int val : arr) {
//				System.out.print(val+" ");
//			}
//			System.out.println();
//		}
		System.out.println(countSquares(matrix));
		scn.close();
	}

	public static int countSquares(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0 || j == 0) {
					sum += matrix[i][j];
				} else {
					if (matrix[i][j] != 0) {
						matrix[i][j] = Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]) + 1;

					}
					sum += matrix[i][j];
				}
			}
		}
		return sum;
	}

}
