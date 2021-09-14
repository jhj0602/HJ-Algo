package ssafy.onlin_learn.dp;

public class StickMake {
	// 길이가 n인 막대를 만들수 있는 방법의 수
	// 1. 길이가 n인 막대(맨뒤에 파란색 막대) : (n-1)cm + 1cm
	// 1. 길이가 n인 막대(맨뒤에 노란색 막대) : (n-1)cm + 1cm
	// 1. 길이가 n인 막대(맨뒤에 빨간색 막대) : (n-2)cm + 1cm
	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 2 };// 파란 노란 빨간
		int n = 6;
		int[] dp = new int[n + 1];
		dp[0] = 1;// 아무 막대도 안스기 때문에 가짓수 한개
		dp[1] = 2;// 파란 노란 막대
		dp[2] = 5;
		
		for (int i = 3; i <=n; i++) {
			dp[i]= dp[i-1]+dp[i-1]+dp[i-2];//길이가 1,1,2인 막대
		}

		System.out.println(dp[n]);
	}

}
