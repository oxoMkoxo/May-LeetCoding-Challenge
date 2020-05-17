/*
 * 438. Find All Anagrams in a String
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * 	Example 1:
 * 		Input:
 * 			s: "cbaebabacd" p: "abc"
 * 		Output:
 * 			[0, 6]
 * 		Explanation:
 * 			The substring with start index = 0 is "cba", which is an anagram of "abc".
 * 			The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * 	Example 2:
 * 		Input:
 * 			s: "abab" p: "ab"
 * 		Output:
 * 			[0, 1, 2]
 * 	Explanation:
 * 			The substring with start index = 0 is "ab", which is an anagram of "ab".
 * 			The substring with start index = 1 is "ba", which is an anagram of "ab".
 * 			The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 * 
 */

package Week3;

import java.util.*;

public class FindAllAnagramsInTheString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		System.out.println(findAnagrams(s.substring(1, s.length() - 1), p.substring(1, p.length() - 1)));
		scn.close();
	}

	public static List<Integer> findAnagrams(String s, String p) {
		int[] map = new int[26];
		char[] pArr = p.toCharArray();
		for (int i = 0; i < pArr.length; i++) {
			map[pArr[i] - 'a']++;
		}

		char[] sArr = s.toCharArray();
		int[] temp = (int[]) map.clone();
		List<Integer> ans = new ArrayList<>();
		int count = 0;
		for (int indx = 0; indx < sArr.length; indx++) {
			temp[sArr[indx] - 'a']--;

			if (count == pArr.length) {
				temp[sArr[indx - count] - 'a']++;
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
			if (tempCheck == 26 && count == pArr.length) {
				ans.add(indx - pArr.length + 1);
			}
		}
		return ans;
	}
}
