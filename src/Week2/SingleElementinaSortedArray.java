/*
 * 540. Single Element in a Sorted Array
 * 
 * You are given a sorted array consisting of only integers where every element appears exactly twice, 
 * except for one element which appears exactly once. Find this single element that appears only once.
 * 
 * 	Example 1:
 * 		Input: [1,1,2,3,3,4,4,8,8]
 * 		Output: 2
 * 
 * 	Example 2:
 * 		Input: [3,3,7,7,10,11,11]
 * 		Output: 10
 * 
 * 	Note: Your solution should run in O(log n) time and O(1) space.
 * 
 * 
 */


package Week2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SingleElementinaSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		int[] nums = new int[st.countTokens()];
		int i = 0;
		while (st.hasMoreElements()) {
			nums[i] = Integer.parseInt(st.nextElement().toString());
			i++;
		}
		System.out.println(singleNonDuplicate(nums));
		scn.close();
	}
	public static int singleNonDuplicate(int[] nums) {
        int lo = 0, len = nums.length, hi = len / 2;

        while (lo < hi){
            int mid = lo + ((hi - lo) / 2);
            if (nums[2 * mid] == nums[2 * mid + 1]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[2 * lo];
    }
//	public int singleNonDuplicate(int[] nums) {
//        int ans = 0;
//        for(int i = 0; i < nums.length; i++){
//            ans ^= nums[i];
//        }
//        return ans;
//    }

}
