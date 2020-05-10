/*
 * 997. Find the Town Judge
 * 
 * In a town, there are N people labeled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * 
 * If the town judge exists, then:
 * 		The town judge trusts nobody.
 * 		Everybody (except for the town judge) trusts the town judge.
 * 		There is exactly one person that satisfies properties 1 and 2.
 * 
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * 
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 * 
 * 
 * 	Example 1:
 * 		Input: N = 2, trust = [[1,2]]
 * 		Output: 2
 * 
 * 	Example 2:
 * 		Input: N = 3, trust = [[1,3],[2,3]]
 * 		Output: 3
 * 
 *	Example 3:
 *		Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 *		Output: -1
 *
 *	Example 4:
 *		Input: N = 3, trust = [[1,2],[2,3]]
 *		Output: -1
 *
 *	Example 5:
 *		Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 *		Output: 3
 *
 *
 *	Note:
 *
 *		1 <= N <= 1000
 *		trust.length <= 10000
 *		trust[i] are all different
 *		trust[i][0] != trust[i][1]
 *		1 <= trust[i][0], trust[i][1] <= N
 * 
 */


package Week2;

import java.util.*;

public class FindtheTownJudge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		String s = scn.next();
		StringTokenizer st = new StringTokenizer(s, "[\\[\\],]");
		int[][] trust = new int[st.countTokens() / 2][2];
		int i = 0;
		while (st.hasMoreElements()) {
			trust[i][0] = Integer.parseInt(st.nextElement().toString());
			trust[i][1] = Integer.parseInt(st.nextElement().toString());
			i++;
		}
//		for (i = 0; i < trust.length; i++) {
//			for (int j = 0; j < trust[i].length; j++) {
//				System.out.print(trust[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(findJudge(N, trust));
		scn.close();

	}

	public static int findJudge(int N, int[][] trust) {
		if (N == 1) {
			return 1;
		}
		int[] oneDCountVisualization = new int[N + 1];

		for (int i = 0; i < trust.length; i++) {

			oneDCountVisualization[trust[i][0]]--;
			oneDCountVisualization[trust[i][1]]++;

		}

		for (int i = 0; i < oneDCountVisualization.length; i++) {
			if (oneDCountVisualization[i] == N - 1) {
				return i;
			}
		}
		return -1;

	}

}
