/*
 * 451. Sort Characters By Frequency
 * 
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * 
 * 	Example 1:
 * 		Input:
 * 			"tree"
 * 		Output:
 * 			"eert"
 * 	Explanation:
 * 			'e' appears twice while 'r' and 't' both appear once.
 * 			So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * 
 * 	Example 2:
 * 		Input:
 * 			"cccaaa"
 * 		Output:
 * 			"cccaaa"
 * 	Explanation:
 * 			Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * 			Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * 	Example 3:
 * 		Input:
 * 			"Aabb"
 * 		Output:
 * 			"bbAa"
 * 	Explanation:
 * 			"bbaA" is also a valid answer, but "Aabb" is incorrect.
 * 			Note that 'A' and 'a' are treated as two different characters.
 */

package Week4;

import java.util.*;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.println(frequencySort(s));
		scn.close();
	}

	public static String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] arr = s.toCharArray();
		for (char c : arr) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		PriorityQueue<Character> q = new PriorityQueue<>(new Comparator<Character>() {
			@Override
			public int compare(Character a, Character b) {
				return map.get(b) - map.get(a);
			}
		});
		for (char chr : map.keySet()) {
			q.add(chr);
		}
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			char ch = q.remove();
			int freq = map.get(ch);
			for (int i = 0; i < freq; i++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
