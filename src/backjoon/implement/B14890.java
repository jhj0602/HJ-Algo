package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14890 {
	static int[][] map;
	static boolean[][] visit;
	static int n, l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0; // 길의 갯수
		for (int i = 0; i < n; i++) {// 0이 오른쪽 //1이 아래쪽
			if (check(i, 0, 0)) {
				cnt++;
			}
			if (check(0, i, 1)) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	private static boolean check(int x, int y, int dir) {// 오른쪽으로 가는거
		int[] height = new int[n];
		boolean[] visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			height[i] = (dir == 0) ? map[x][y + i] : map[x + i][y];
		}
		for (int i = 0; i < n - 1; i++) {
			if (height[i] == height[i + 1]) {
				continue;
			}
			if (Math.abs(height[i] - height[i + 1]) == 1) {// 차이가 1일 경우이다
				if (height[i] + 1 == height[i + 1]) {// 아래에서 위로 경사로이다
					for (int j = i; j > i - l; j--) {
						if (j < 0 || height[j] != height[i] || visit[j]) {
							return false;
						}
						visit[j] = true;
					}
				} else {
					for (int j = i + 1; j <= i + l; j++) {
						if (j >= n || height[j] != height[i + 1] || visit[j]) {
							return false;
						}
						visit[j] = true;
					}
				}
			} else if (Math.abs(height[i] - height[i + 1]) > 1) {
				return false;
			}
		}

		return true;
	}

}
