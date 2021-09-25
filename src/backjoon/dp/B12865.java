package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12865 {
	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());// 목표무게
		int[] weights = new int[n + 1];
		int[] profits = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
//		int[][] dp = new int[n + 1][k + 1];
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= k; j++) {
//
//				if (weights[i] <= j) {// 해당물건을 가방에 넣을 수 있다.
//					dp[i][j] = Math.max(dp[i - 1][j], profits[i] + dp[i - 1][j - weights[i]]);
//
//				} else {//해당 물건을 가방에 넣을수 없다.
//					dp[i][j] = dp[i - 1][j];
//				}
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}

		int dp[] = new int[k + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = k; j >= k; j--) {
				System.out.println(Arrays.toString(dp));
				dp[k] = Math.max(dp[j], profits[i] + dp[k - weights[i]]);

			}

		}
		System.out.println(dp[k]);
	}

}
