package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2468 {
	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] area;
	static boolean[][] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		area = new int[100][100];
		visited = new boolean[100][100];
		int max = 0;
		int min = 100;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if (area[i][j] > max)
					max = area[i][j];
				if (area[i][j] < min)
					min = area[i][j];
			}
		}
		int result = 1;
		for (int i = min; i < max; i++) {
			int cnt = 0;
			for (int j = 0; j < 100; j++) {
				Arrays.fill(visited[j], false);
			}
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (!visited[y][x] && area[y][x] > i) {
						dfs(x, y, i);
						cnt++;
					}
				}
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}

	static void dfs(int x, int y, int h) {
		if (x < 0 || x >= N || y < 0 || y >= N) {
			return;
		}

		// 이미 방문한 위치거나 물에 잠긴 위치거나
		if (visited[y][x] || area[y][x] <= h) {
			return;
		}

		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];

			dfs(px, py, h);
		}

	}
}
