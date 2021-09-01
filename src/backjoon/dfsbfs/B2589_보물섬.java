package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589_보물섬 {

	static int N, M;
	static char[][] arr;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visit;
	static int count = 0;
	static int max = 0;
	static ArrayList<Dot> list = new ArrayList<>();
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = line.charAt(j);
				if (arr[i][j] == 'L') {
					list.add(new Dot(i, j));
				}
			}
		}
		for (Dot d : list) {
			visit = new boolean[N][M];
			bfs(d.x, d.y);
		}
		System.out.println(max);
	}

	static void bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		dist = new int[N][M];
		visit[x][y] = true;
		q.offer(new Dot(x, y));
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			for (int i = 0; i < 4; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];
				if (px >= 0 && px < N && py >= 0 && py < M && arr[px][py] == 'L' && !visit[px][py]) {
					visit[px][py] = true;
					dist[px][py] = dist[dot.x][dot.y] + 1;
					q.offer(new Dot(px, py));
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Math.max(max, dist[i][j]);
			}
		}
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
