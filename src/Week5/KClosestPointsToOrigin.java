/*
 * 973. K Closest Points to Origin
 * 
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * 
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * 
 * 	Example 1:
 * 
 * 		Input: points = [[1,3],[-2,2]], K = 1
 * 		Output: [[-2,2]]
 * 	Explanation:
 * 		The distance between (1, 3) and the origin is sqrt(10).
 * 		The distance between (-2, 2) and the origin is sqrt(8).
 * 		Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * 		We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * 
 * 	Example 2:
 * 		Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * 		Output: [[3,3],[-2,4]]
 * 	(The answer [[-2,4],[3,3]] would also be accepted.)
 * 
 * 	Note:
 * 		1 <= K <= points.length <= 10000
 * 		-10000 < points[i][0] < 10000
 * 		-10000 < points[i][1] < 10000
 */
package Week5;

import java.util.*;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int K = scn.nextInt();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		int[][] points = new int[st.countTokens() / 2][2];
		int i = 0;
		while (st.hasMoreElements()) {
			points[i][0] = Integer.parseInt(st.nextElement().toString());
			points[i][1] = Integer.parseInt(st.nextElement().toString());
			i++;
		}
		int[][] ans = kClosest(points, K);
		System.out.print("[");
		for (int[] arr : ans) {
			System.out.print("[" + arr[0] + "," + arr[1] + "]");
		}
		System.out.print("]");
		scn.close();
	}

	public static int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				Integer one = arr1[0] * arr1[0] + arr1[1] * arr1[1];
				Integer two = arr2[0] * arr2[0] + arr2[1] * arr2[1];
				return one.compareTo(two);
			}
		});
		int[][] ans = new int[K][2];
		for (int i = 0; i < K; i++) {
			ans[i][0] = points[i][0];
			ans[i][1] = points[i][1];
		}
		return ans;

	}

}
