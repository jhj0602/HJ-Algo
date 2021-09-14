package ssafy.onlin_learn.dp;

import java.util.Arrays;

public class ColorAPT {
// dp[n][2] : n층의 아파트를 칠할수있는 방법의 수 dp[n][0] +d[n][1]
// dp[n][0] n층의 아파트를 노락색으로 칠할수 있는 방법의수
// dp[n][1] n층의 아파트를 파란색으로 칠할 수 있는 방법의 수 

	public static void main(String[] args) {
		int n = 8;
		int[][] dp = new int[n + 1][2];
		int yellow = 0;
		int blue = 1;
		// 초기값 지정
		dp[1][yellow] = 1;// 노랑
		dp[1][blue] = 1;// 파랑
		for (int i = 2; i <= n; i++) {
			// i층 건물에 노란색을 칠할 수 있는 경우 : 아래층(i-1)이 노란색이거나 파란색
			// i층 건물에 파란색을 칠할 수 있는 경우 : 아래층(i-1)이 노란색이어야함
			dp[i][yellow] = dp[i - 1][yellow] + dp[i - 1][blue];
			dp[i][blue] = dp[i - 1][yellow];
		}
		for (int[] is : dp) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println(dp[n][yellow] + dp[n][blue]);

		// 아래층을 나타내는 변수 2개 윗층을 나타내는 변수 2개
		System.out.println("다른 방법");
		int up_yellow = 0, up_blue = 0;
		int down_yellow = 1, down_blue = 1;

		for (int i = 2; i <= n; i++) {
			// i층 윗층에 건물에 노란색을 칠할 수 있는 경우 : 아래층(i-1)이 노란색이거나 파란색
			// i층 건물에 파란색을 칠할 수 있는 경우 : 아래층(i-1)이 노란색이어야함
			up_yellow = down_yellow + down_blue;
			up_blue = down_yellow;

			down_yellow = up_yellow;
			down_blue = up_blue;

		}
		System.out.println(up_yellow+up_blue);

	}

}
