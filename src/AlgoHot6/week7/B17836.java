package AlgoHot6.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//공주님 구하기 
public class B17836 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n, m, t;
	static int[][] map;
	static Dot weapon;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					weapon = new Dot(i, j);
				}
			}
		}
		// 그냥 갈꺼
		int nomalMove = bfs(0, 0);
		// 무기 가지고 갈꺼
		System.out.println(nomalMove>t||nomalMove==0?"Fail":nomalMove);
	}

	private static int bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<>();
		int[][] dist = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		visit[x][y] = true;
		boolean flag = false;// 무기 먹었는지 검사
		q.offer(new Dot(x, y));
		while (!q.isEmpty()) {
			Dot c = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + c.x;
				int ny = dy[i] + c.y;
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny]) {
					if (!flag) {
						if (map[nx][ny] != 1) {
							visit[nx][ny] = true;
							dist[nx][ny] = dist[c.x][c.y] + 1;
							q.offer(new Dot(nx, ny));
							if (map[nx][ny] == 2) {
								flag = true;
							}
						}
					} else {// 무기 든거
						visit[nx][ny] = true;
						dist[nx][ny] = dist[c.x][c.y] + 1;
						q.offer(new Dot(nx, ny));
					}
				}
			}
		}
		return dist[n - 1][m - 1];
	}

	static class Dot {
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
