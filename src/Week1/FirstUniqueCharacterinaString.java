/*
 * 387. First Unique Character in a String
 * 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * 	Examples:
 * 		s = "leetcode"
 * 		return 0.
 * 
 * 		s = "loveleetcode",
 * 		return 2.
 * 
 * 	Note: You may assume the string contain only lowercase letters.
 */

package Week1;

import java.util.Scanner;

public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.println(firstUniqChar(s));
		scn.close();
	}

	public static int firstUniqChar(String s) {
		int[] freq = new int[26];
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			freq[arr[i] - 'a'] += 1;
		}
		for (int i = 0; i < arr.length; i++) {
			if (freq[arr[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;

	}

}
