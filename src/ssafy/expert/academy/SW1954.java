package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1954 {
	static int N;
	static int[][] d = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] arr;
	static boolean[][] visit;
	static int count = 1;
	static int patternCount = 0;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(br.readLine());
			count = 1;
			arr = new int[N][N];
			visit = new boolean[N][N];
			arr[0][0] = count;
			visit[0][0] = true;
			dfs(0, 0);
			sb.append("#" + test_case + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		if (count == N * N) {
			return;
		}
		int px = x + d[patternCount][0];
		int py = y + d[patternCount][1];
		if (0 <= px && N > px && 0 <= py && N > py && !visit[px][py]) {
			count++;
			arr[px][py] = count;
			visit[px][py] = true;
			dfs(px, py);
		} else {
			patternCount++;
			if (patternCount == 4) {
				patternCount = 0;
			}
			if (patternCount == 1) {
				dfs(x + d[patternCount][0] - 1, y + d[patternCount][1]);
			} else if (patternCount == 2) {
				dfs(x + d[patternCount][0], y + d[patternCount][1] + 1);
			} else if (patternCount == 3) {
				dfs(x + d[patternCount][0] + 1, y + d[patternCount][1]);
			} else if (patternCount == 0) {
				dfs(x + d[patternCount][0], y + d[patternCount][1] - 1);
			}
			
//	if (patternCount == 1) {
//			px -= 1;
//			} else if (patternCount == 2) {
//				py += py + 1;
//			} else if (patternCount == 3) {
//				px += 1;
//			} else if (patternCount == 0) {
//				py -= 1;
//			}
//			dfs(px, py);
			
		}

	}


}
