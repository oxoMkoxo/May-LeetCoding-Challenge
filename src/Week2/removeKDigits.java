/*
 * 402. Remove K Digits
 * 
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number 
 * is the smallest possible.
 * 
 * 	Note:
 * 		The length of num is less than 10002 and will be >= k.
 * 		The given num does not contain any leading zero.
 * 
 * 	Example 1:
 * 		Input: num = "1432219", k = 3
 * 		Output: "1219"
 * 	Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 
 * 	Example 2:
 * 		Input: num = "10200", k = 1
 * 		Output: "200"
 * 	Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * 
 * 	Example 3:
 * 		Input: num = "10", k = 2
 * 		Output: "0"
 * 	Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 
 * 
 */

package Week2;

import java.util.Scanner;

public class removeKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String num = scn.next();
		int k = scn.nextInt();
		System.out.println(removeKdigits(num, k));
		scn.close();
	}

	public static String removeKdigits(String num, int k) {
		if (k >= num.length()) {
			return "0";
		}
		for (int i = 0, j = 1; i < num.length() && k > 0 && j < num.length();) {
			if ((int) num.charAt(i) > (int) num.charAt(j)) {
				num = num.substring(0, i) + num.substring(i + 1);
				k--;
				if (i > 0) {
					i--;
				}
				if (j > 1) {
					j--;
				}
			} else {
				i++;
				j++;
			}

			while (k > 0 && j >= num.length()) {
				i = num.length() - 1;
				num = num.substring(0, i) + num.substring(i + 1);
				k--;
			}
		}
		while (num.charAt(0) == '0' && num.length() > 1) {
			num = num.substring(1);
		}
		return num;
	}

}
