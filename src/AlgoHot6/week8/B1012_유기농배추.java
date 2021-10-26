package AlgoHot6.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1012_유기농배추 {
	static int n, m, count, map[][];
	static boolean[][] visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			ArrayList<Dot> list = new ArrayList<>();
			visit = new boolean[n][m];
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Dot(x, y));
				map[x][y] = 1;
			}
			count=0;
			for (Dot d : list) {
				if (!visit[d.x][d.y]) {
					bfs(d.x, d.y);
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);

	}

	private static void bfs(int x, int y) {
		count++;
		Queue<Dot> q = new LinkedList<>();
		q.offer(new Dot(x, y));
		visit[x][y] = true;
		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && map[nx][ny] == 1) {
					q.offer(new Dot(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}

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
