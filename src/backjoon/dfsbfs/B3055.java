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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		Dot s = null;
		Dot d = null;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'S') {
					s = new Dot(i, j);
				} else if (map[i][j] == 'D') {
					d = new Dot(i, j);
				} else if (map[i][j] == '*') {
					list.add(new Dot(i, j));
				}
			}
		}
		bfs(s);
		System.out.println(dist[d.x][d.y]);
	}

	static void bfs(Dot s) {
		Queue<Dot> q = new LinkedList<Dot>();
		Queue<Dot>[] wQ = new LinkedList[list.size()];
		for (int i = 0; i < list.size(); i++) {
			wQ[i] = new LinkedList<>();
		}
		boolean[][] visit = new boolean[N][M];
		boolean[][] goVisit = new boolean[N][M];
		dist = new int[N][M];
		goVisit[s.x][s.y] = true;
		visit[s.x][s.y] = true;
		for (int i = 0; i < list.size(); i++) {
			visit[list.get(i).x][list.get(i).y] = true;
			wQ[i].offer(new Dot(list.get(i).x, list.get(i).y));
		}

		q.offer(new Dot(s.x, s.y));
		while (!q.isEmpty()) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(visit[i][j] + " " + dist[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			for (int i = 0; i < wQ.length; i++) {
				Dot currentW = wQ[i].poll();
				for (int k = 0; k < wQ[i].size(); k++) {
					for (int j = 0; j < 4; j++) {
						int px = currentW.x + dx[j];
						int py = currentW.y + dy[j];
						if (px >= 0 && px < N && py >= 0 && py < M && map[px][py] != 'D' && map[px][py] != 'X'
								&& !visit[px][py]) {
							visit[px][py] = true;
							wQ[i].offer(new Dot(px, py));
						}
					}
				}
			}
			Dot currentS = q.poll();

			for (int i = 0; i < 4; i++) {
				int px = currentS.x + dx[i];
				int py = currentS.y + dy[i];
				if (px >= 0 && px < N && py >= 0 && py < M && map[px][py] != 'X' && !visit[px][py]
						&& !goVisit[px][py]) {
					goVisit[px][py] = true;

					dist[px][py] = dist[currentS.x][currentS.y] + 1;
					q.offer(new Dot(px, py));
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
