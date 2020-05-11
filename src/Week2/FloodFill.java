/*
 * 733. Flood Fill
 * 
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * 
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor,
 * "flood fill" the image.
 * 
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel 
 * of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels 
 * (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels 
 * with the newColor.
 * 
 * At the end, return the modified image.
 * 
 * 	Example 1:
 * 		Input: 
 * 			image = [[1,1,1],[1,1,0],[1,0,1]]
 * 			sr = 1, sc = 1, newColor = 2
 * 		Output: [[2,2,2],[2,2,0],[2,0,1]]
 * 		Explanation:
 * 			From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
 * 			by a path of the same color as the starting pixel are colored with the new color.
 * 			Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * 
 * 	Note:
 * 		The length of image and image[0] will be in the range [1, 50].
 * 		The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * 		The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 * 
 * 
 * 
 */


package Week2;

import java.util.*;

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int sr = scn.nextInt();
		int sc = scn.nextInt();
		int newColor = scn.nextInt();
		StringTokenizer st = new StringTokenizer(s, "[],");
		String[] arr = s.split("[\\]]");
		int I = arr.length;
		int J = st.countTokens() / I;
		int[][] image = new int[I][J];
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				image[i][j] = Integer.parseInt(st.nextElement().toString());
			}
		}
		image = floodFill(image, sr, sc, newColor);
		System.out.print("[");
		for (int i = 0; i < I; i++) {
			System.out.print("[");
			for (int j = 0; j < J; j++) {
				if (j == J - 1) {
					System.out.print(image[i][j]);
				} else {
					System.out.print(image[i][j] + ",");
				}
			}
			if (i == I - 1) {
				System.out.print("]");
			} else {
				System.out.print("],");
			}
		}
		System.out.print("]");

		scn.close();

	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		recurr(image, sr, sc, image[sr][sc], newColor);
		return image;

	}

	public static void recurr(int[][] image, int sr, int sc, int oldColor, int newColor) {

		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == newColor) {
			return;
		}

		if (image[sr][sc] != oldColor) {
			return;
		}
		image[sr][sc] = newColor;

		int[][] arr = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

		for (int i = 0; i < arr.length; i++) {
			recurr(image, sr + arr[i][0], sc + arr[i][1], oldColor, newColor);
		}

	}

}
