package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2001 {

	static int[][] arr;
	static int maxValue = 0;
	static int N, M;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tempMax = dfs(i, j);
					maxValue = Math.max(tempMax, maxValue);
				}
			}

			sb.append("#" + test_case + " " + maxValue + "\n");
		}
		System.out.println(sb);

	}

	private static int dfs(int i, int j) {
		int sum = 0;
		if (i + M - 1 < N && j + M - 1 < N) {
			for (int k = i; k < i + M; k++) {
				for (int z = j; z < j + M; z++) {
					sum += arr[k][z];
				}

			}
			return sum;
		}

		return sum;

	}

}
