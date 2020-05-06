/*
 * 169. Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more
 * than floor( n/2 ) times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * 	Example 1:
 * 		Input: [3,2,3]
 * 		Output: 3
 * 	Example 2:
 *		Input: [2,2,1,1,1,2,2]
 *		Output: 2
 * 
 * 
 */



package Week1;

import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scn.nextInt();
		}
		System.out.println(majorityElement(nums));
		scn.close();
	}

	public static int majorityElement(int[] nums) {
		int majCount = nums.length / 2;
		Arrays.sort(nums);
		int count = 1;
		int element = nums[0];
		int ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			while (i < nums.length && nums[i] == element) {
				count++;
				i++;
			}
			if (count > majCount) {
				majCount = count;
				ans = element;
			}
			if (i < nums.length) {
				element = nums[i];
			}
			count = 1;
		}
		return ans;
	}

}
