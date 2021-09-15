package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463Re {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x= Integer.parseInt(br.readLine());
		int[] dp = new int[x + 1];
		dp[1] = 0;
		for (int i = 2; i <=x; i++) {
			dp[i]=dp[i-1]+1;
			if(dp[i]%3==0) {
				dp[i] = Math.min(dp[i/3]+1, dp[i]);
			}
			if(dp[i]%2==0) {
				dp[i] = Math.min(dp[i/2]+1, dp[i]);
			}
		}
		System.out.println(dp[x]);
	}

}
