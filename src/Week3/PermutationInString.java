/*
 * 567. Permutation in String
 * 
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
 * In other words, one of the first string's permutations is the substring of the second string.
 * 
 * 	Example 1:
 * 		Input: s1 = "ab" s2 = "eidbaooo"
 * 		Output: True
 * 	Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * 	Example 2:
 * 		Input:s1= "ab" s2 = "eidboaoo"
 * 		Output: False
 * 
 * 	Note:
 * 
 * 		The input strings only contain lower case letters.
 * 		The length of both given strings is in range [1, 10,000].
 * 
 * 
 */
package Week3;

import java.util.Scanner;

public class PermutationInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		System.out.println(checkInclusion(s.substring(1, s.length() - 1), p.substring(1, p.length() - 1)));
		scn.close();

	}

	public static boolean checkInclusion(String s1, String s2) {
		int[] map = new int[26];
		char[] s1Arr = s1.toCharArray();
		for (int i = 0; i < s1Arr.length; i++) {
			map[s1Arr[i] - 'a']++;
		}
		char[] s2Arr = s2.toCharArray();
		int window = s1Arr.length;
		int count = 0;
		int[] temp = (int[]) map.clone();
		for (int i = 0; i < s2Arr.length; i++) {
			temp[s2Arr[i] - 'a']--;

			if (count == window) {
				temp[s2Arr[i - count] - 'a']++;
			} else {
				count++;
			}

			int tempCheck = 0;
			while (tempCheck < temp.length) {
				if (temp[tempCheck] != 0) {
					break;
				}
				tempCheck++;
			}
			if (tempCheck == 26 && count == window) {
				return true;
			}
		}
		return false;
	}
}
