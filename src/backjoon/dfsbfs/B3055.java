package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055 {

	static int N, M;
	static char[][] map;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int max = 0;
	static ArrayList<Dot> list = new ArrayList<>();
	static int[][] dist;
	static Queue<Dot> wQ;
	static Queue<Dot> q;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		Dot s = null;
		Dot d = null;
		wQ = new LinkedList<>();
		q = new LinkedList<>();
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'S') {
					q.offer(new Dot(i, j));
					visit[i][j] = true;
				} else if (map[i][j] == 'D') {
					d = new Dot(i, j);
				} else if (map[i][j] == '*') {
					wQ.offer(new Dot(i, j));
					visit[i][j] = true;
				}
			}
		}
		bfs();
		System.out.println(dist[d.x][d.y] == 0 ? "KAKTUS" : dist[d.x][d.y]);
	}

	static void bfs() {
		dist = new int[N][M];
		while (!q.isEmpty()) {
			int wSize = wQ.size();
			for (int i = 0; i < wSize; i++) {
				Dot currentW = wQ.poll();
				for (int j = 0; j < 4; j++) {
					int px = currentW.x + dx[j];
					int py = currentW.y + dy[j];
					if (px >= 0 && px < N && py >= 0 && py < M && map[px][py] != 'D' && map[px][py] != 'X'
							&& !visit[px][py]) {
						visit[px][py] = true;
						wQ.offer(new Dot(px, py));
					}
				}
			}
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				Dot currentS = q.poll();
				for (int j = 0; j < 4; j++) {
					int px = currentS.x + dx[j];
					int py = currentS.y + dy[j];
					if (px >= 0 && px < N && py >= 0 && py < M && map[px][py] != 'X' && !visit[px][py]) {
						visit[px][py] = true;
						dist[px][py] = dist[currentS.x][currentS.y] + 1;
						q.offer(new Dot(px, py));
						if (map[px][py] == 'D') {
							return;
						}
					}

				}
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
