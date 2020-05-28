package Week4;

import java.util.*;

public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] ans = countBits(n);
		System.out.print("[");
		for (int i = 0; i < ans.length - 1; i++) {
			System.out.print(ans[i] + ",");
		}
		System.out.print(ans[ans.length - 1] + "]");
		scn.close();
	}

	public static int[] countBits(int num) {
		int[] arr = new int[num + 1];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || i == 1) {
				arr[i] = i;
			} else {
				arr[i] = (i % 2 == 0) ? arr[i >> 1] : arr[i - 1] + 1;
			}
		}
		return arr;
	}
}
