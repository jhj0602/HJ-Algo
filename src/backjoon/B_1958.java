package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line1 = br.readLine().trim().toCharArray();
		char[] line2 = br.readLine().trim().toCharArray();
		char[] line3 = br.readLine().trim().toCharArray();
		int[][][] dp = new int[line1.length + 1][line2.length + 1][line3.length + 1];
		for (int i = 1; i <= line1.length; i++) {
			for (int j = 1; j <= line2.length; j++) {
				for (int k = 1; k <= line3.length; k++) {
					if (line1[i - 1] == line2[j - 1] && line2[j - 1] == line3[k - 1]) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));

					}
				}
			}
		}
		System.out.print(dp[line1.length][line2.length][line3.length]);

	}

}
