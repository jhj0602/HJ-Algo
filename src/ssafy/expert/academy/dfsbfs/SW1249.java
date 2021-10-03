package ssafy.expert.academy.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1249 {

	static boolean[][] visit;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	public static int n;
	public static int[][] map;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			n = Integer.parseInt(br.readLine());

			map = new int[n][n];

			visit = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}

			sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
		}

		System.out.println(sb);
	}

	static int bfs() {
		int answer = Integer.MAX_VALUE;
		int[][] dist = new int[n][n];

		Queue<Dot> q = new LinkedList<Dot>();
		q.offer(new Dot(0, 0));
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			for (int i = 0; i < 4; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];
				if (dot.x == n - 1 && dot.y == n - 1) {
					answer = (answer > dist[dot.x][dot.y]) ? dist[dot.x][dot.y] : answer;
					continue;
				}
				if (answer <= dist[dot.x][dot.x]) {
					continue;
				}

				if (px >= 0 && px < n && py >= 0 && py < n) {
					if (!visit[px][py] || dist[px][py] < dist[dot.x][dot.y] + map[px][py]) {
						visit[px][py] = true;
						q.offer(new Dot(px, py));
						dist[px][py] = dist[dot.x][dot.y] + map[px][py];
					}
				}
			}
		}
		return dist[n - 1][n - 1];
	}

	static class Dot {
		int x;
		int y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
