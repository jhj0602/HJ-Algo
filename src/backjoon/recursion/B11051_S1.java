package backjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11051_S1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (i == j || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007;
				}
			}

		}
		System.out.println(dp[N][K]);
	}
}
