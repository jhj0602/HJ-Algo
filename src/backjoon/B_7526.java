package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7526 {
	static int[] dx = { -2, -1, 2, 1, 2, 1, -2, -1 };
	static int[] dy = { 1, 2, 1, 2, -1, -2, -1, -2 };
	static int[][] map;
	static boolean[][] visited;
	static int startX, startY, endX, endY;
	static Queue<dot> q = new LinkedList<dot>();
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			dfs(new dot(startX, startY));

			sb.append(map[endX][endY] + "\n");
			reset();
		}
		System.out.println(sb);

	}

	private static void reset() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
	}

	static void dfs(dot d) {
		if (d.x == endX && d.y == endY) {
			return;
		}
		visited[d.x][d.y] = true;

		q.add(d);

		while (!q.isEmpty()) {
			dot t = q.poll();
			int x1 = t.x;
			int y1 = t.y;

			for (int i = 0; i < 8; i++) {
				int x2 = x1 + dx[i];
				int y2 = y1 + dy[i];

				if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < n && !visited[x2][y2]) {
					q.add(new dot(x2, y2));
					visited[x2][y2] = true;
					map[x2][y2] = map[x1][y1] + 1;
				}
			}
		}
	}

}

class dot {
	int x;
	int y;

	public dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}