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