/*
 * 383. Ransom Note
 * 
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, 
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, 
 * it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note:
 * 	You may assume that both strings contain only lowercase letters.
 * 
 * 		canConstruct("a", "b") -> false
 * 		canConstruct("aa", "ab") -> false
 * 		canConstruct("aa", "aab") -> true
 * 
 */


package Week1;

import java.util.Scanner;

public class RansomNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String ransomNote = scn.next();
		String magazine = scn.next();
		System.out.println(canConstruct(ransomNote, magazine));
		scn.close();
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] arrToTrack = new int[26];
		char[] magArr = magazine.toCharArray();
		char[] ranArr = ransomNote.toCharArray();
		for (int i = 0; i < magArr.length; i++) {
			arrToTrack[magArr[i] - 'a'] -= 1;
		}
		for (int i = 0; i < ranArr.length; i++) {
			arrToTrack[ranArr[i] - 'a'] += 1;
		}
		for (int i = 0; i < arrToTrack.length; i++) {
			if (arrToTrack[i] > 0) {
				return false;
			}
		}
		return true;
	}

}
