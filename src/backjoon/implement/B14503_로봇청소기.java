package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503_로봇청소기 {
	static int[][] map;
	static int n, m;
	static int[] dx = { -1, 0, 1, -1 };// 북동남서
	static int[] dy = { 0, 1, 0, 0 };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(r, c, d);

	}

	private static void clean(int r, int c, int d) {
		if (map[r][c] == 0) {
			 map[r][c] = 2;
			count++;
		}
		int dir = (d + 3) % 4;

	}
}
