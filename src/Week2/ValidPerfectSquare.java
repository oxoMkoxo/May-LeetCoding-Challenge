/*
 * 367. Valid Perfect Square
 * 
 * 	Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * 
 * 	Note: Do not use any built-in library function such as sqrt.
 * 
 * 	Example 1:
 * 		Input: 16
 * 		Output: true
 * 
 * 	Example 2:
 * 		Input: 14
 * 		Output: false
 * 
 */



package Week2;

import java.util.Scanner;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		System.out.println(isPerfectSquare(num));
		scn.close();
	}

	public static boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		int lo = 2;
		int hi = num / 2;
		while (hi > 46340) {
			hi = 46340;
		}

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int ans = (mid * mid);
			if (ans < num) {
				lo = mid + 1;
			} else if (ans > num) {
				hi = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}

}
