/*
 * 1232. Check If It Is a Straight Line
 * 
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. 
 * Check if these points make a straight line in the XY plane.
 * 
 * Example 1:
 * 		Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 		Output: true
 * 
 * Example 2:
 * 		Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 		Output: false
 * 
 * Constraints:
 * 		2 <= coordinates.length <= 1000
 * 		coordinates[i].length == 2
 * 		-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * 		coordinates contains no duplicate point.
 */



package Week2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIfItIsaStraightLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		Pattern brackCount = Pattern.compile("[\\[]");
		Matcher count = brackCount.matcher(s);
		int rows = (int) (count.results().count() - 1);
		StringTokenizer st = new StringTokenizer(s, "[^(\\\\[).*(\\\\]),]");
		int noOfDigits = st.countTokens();
		int cols = noOfDigits / rows;
		int[][] coordinates = new int[rows][cols];
		int i = 0;
		int j = 0;
		while (st.hasMoreElements()) {
			if (j >= cols) {
				i++;
				j = 0;
			}
			coordinates[i][j] = Integer.parseInt(st.nextToken());
			j++;
		}
		
//		for( i=0;i<coordinates.length;i++) {
//			for( j=0; j<coordinates[i].length;j++) {
//				System.out.print(coordinates[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.println(checkStraightLine(coordinates));
		scn.close();
	}

	public static boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length < 2) {
			return true;
		}
		int dx = coordinates[1][0] - coordinates[0][0];
		int dy = coordinates[1][1] - coordinates[0][1];
		float m = (float) dy / dx;

		for (int i = 2; i < coordinates.length; i++) {
			float dm = (float) (coordinates[i][1] - coordinates[i - 1][1])
					/ (coordinates[i][0] - coordinates[i - 1][0]);
			if (m != dm) {
				return false;
			}
		}
		return true;
	}

}
