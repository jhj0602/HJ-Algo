package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2665_미로탐색 {
	static int[][] arr, map;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= n; j++) {
				arr[i][j] = str.charAt(j - 1) - '0';
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs(1, 1);
		System.out.println(map[n][n]);
	}

	static void bfs(int x, int y) {
		Queue<dot> q = new LinkedList<dot>();
		q.offer(new dot(x, y));
		map[x][y] = 0;
		while (!q.isEmpty()) {
			dot dot = q.poll();
			for (int i = 0; i < 4; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];
				if (px >= 1 && px <=n && py >= 1 && py <= n && map[px][py] > map[dot.x][dot.y]) {
					if (arr[px][py] == 1) {
						q.offer(new dot(px, py));
						map[px][py] = map[dot.x][dot.y];
					} else {
						q.offer(new dot(px, py));
						map[px][py] = map[dot.x][dot.y] + 1;
					}
				}
			}
		}
	}

	static class dot {
		int x;
		int y;

		dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
