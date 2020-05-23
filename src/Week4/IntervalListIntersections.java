package Week4;

import java.util.*;

public class IntervalListIntersections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String t = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		StringTokenizer st2 = new StringTokenizer(t, "[\\[\\],]");
		int[][] A = new int[st.countTokens() / 2][2];
		int[][] B = new int[st.countTokens() / 2][2];

		int i = 0;
		while (st.hasMoreElements()) {
			A[i][0] = Integer.parseInt(st.nextElement().toString());
			A[i][1] = Integer.parseInt(st.nextElement().toString());
			i++;
		}
		i = 0;
		while (st2.hasMoreElements()) {
			B[i][0] = Integer.parseInt(st2.nextElement().toString());
			B[i][1] = Integer.parseInt(st2.nextElement().toString());
			i++;
		}
//		for (i = 0; i < trust.length; i++) {
//			for (int j = 0; j < trust[i].length; j++) {
//				System.out.print(trust[i][j]);
//			}
//			System.out.println();
//		}
		int[][] ans = intervalIntersection(A, B);
		System.out.print("[");
		for (int j = 0; j < ans.length; j++) {
			System.out.print("[" + ans[j][0] + "," + ans[j][1] + "]");
		}
		System.out.print("]");
		scn.close();
	}

	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> ans = new ArrayList<>();
		int i = 0, j = 0;

		while (i < A.length && j < B.length) {
			int lo = Math.max(A[i][0], B[j][0]);
			int hi = Math.min(A[i][1], B[j][1]);
			if (lo <= hi)
				ans.add(new int[] { lo, hi });

			if (A[i][1] < B[j][1])
				i++;
			else
				j++;
		}

		return ans.toArray(new int[ans.size()][]);
	}

}
