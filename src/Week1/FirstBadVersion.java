/*
 * 278. First Bad Version
 * 
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest
 * version of your product fails the quality check. Since each version is developed based on the previous version, 
 * all the versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the 
 * following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function 
 * to find the first bad version. You should minimize the number of calls to the API.
 * 
 * 	Example:
 * 		Given n = 5, and version = 4 is the first bad version.
 * 		call isBadVersion(3) -> false
 * 		call isBadVersion(5) -> true
 * 		call isBadVersion(4) -> true
 * 		Then 4 is the first bad version. 
 */
package Week1;

import java.util.Scanner;

public class FirstBadVersion extends VersionControl {
	public FirstBadVersion(int size, int firstBV) {
		// TODO Auto-generated constructor stub
		super(firstBV);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		int firstBV = scn.nextInt();
		FirstBadVersion fbv = new FirstBadVersion(size, firstBV);
		System.out.println(fbv.firstBadVersion(size + 1));
		scn.close();
	}

	public int firstBadVersion(int n) {
		int lo = 1;
		int hi = n;
		if (isBadVersion(1)) {
			return 1;
		} else {
			if (lo == hi) {
				return -1;
			}
		}

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (isBadVersion(mid)) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

}

class VersionControl {
	private int firstBad;

	public VersionControl(int firstBadVersion) {
		// TODO Auto-generated constructor stub
		firstBad = firstBadVersion;
	}

	protected boolean isBadVersion(int indx) {
		boolean res = false;
		if (indx >= firstBad) {
			res = true;
		}
		return res;
	}
}