/*
 * 476. Number Complement
 * 
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * 
 * 	Example 1:
 * 		Input: 5
 * 		Output: 2
 * 		Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. 
 * 		So you need to output 2.
 * 
 * 	Example 2:
 * 		Input: 1
 * 		Output: 0
 * 		Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. 
 * 		So you need to output 0.
 */
package Week1;

import java.util.Arrays;
import java.util.Scanner;

public class NumberComplement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		System.out.println(findComplement(num));
		scn.close();
	}

	public static int findComplement(int num) {
		int[] arr = new int[32];
		Arrays.fill(arr, 2);
		int indx = 0;
		while (num != 0) {
			int rem = num % 2;
			if (rem == 0) {
				rem = 1;
			} else {
				rem = 0;
			}
			arr[indx] = rem;
			indx++;
			num = num / 2;
		}

		int ans = 0;
		int mul = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2) {
				break;
			}
			ans += (arr[i] * mul);
			mul *= 2;

		}
		return (int) ans;

	}

}
