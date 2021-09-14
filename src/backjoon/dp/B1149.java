package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int r, g, b;
		int[][] dp = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			dp[i][0] = r + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = g + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = b + Math.min(dp[i - 1][0], dp[i - 1][1]);
			System.out.println(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]);
		}
		System.out.println(Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2])));
	}
}
