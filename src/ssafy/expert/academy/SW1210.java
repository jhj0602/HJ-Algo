package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1210 {
	static int[] dx = { 0, 0 }; // 좌우
	static int[] dy = { -1, 1 };
	static int[] dxUnder = { 1 }; // 하
	static int[] dyUnder = { 0, };
	static int start;
	static boolean flag = false;
	static int[][] arr;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int k = 0; k < 10; k++) {
				flag = false;
				start = k;
				visit = new boolean[100][100];
				dfs(k, 0, false);
				if (flag) {
					System.out.println(start);
					sb.append(start + "\n");
					break;
				}

			}

		}
		System.out.println(sb);

	}

	private static void dfs(int startX, int startY, boolean dir) {// 방향전환을 했다면 boolean dir = false 안했다면 dir = true

		if (!dir) {
			
			int px = startX + dxUnder[0];
			int py = startY + dyUnder[0];
			if (0 <= px && 100 > px && 0 <= py && 100 > py) {
				if (arr[px][py] == 1) {
					visit[px][py] = true;
					dfs(px, py, true);
				} else if (arr[px][py] == 2) {
					System.out.println("Zz");
					flag = true;
					return;
				}
			}

		} else {
			for (int i = 0; i < 2; i++) {
				int px = startX + dx[i];
				int py = startY + dy[i];
				if (0 <= px && 100 > px && 0 <= py && 100 > py) {
					if (arr[px][py] == 1) {
						visit[px][py] = true;
						dfs(px, py, false);
					} else if (arr[px][py] == 2) {
						System.out.println("Zzzz");
						flag = true;
						return;
					}
					break;

				}

			}
		}
	}

}
