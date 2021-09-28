package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16234_인구이동 {

	static int N, L, R;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int dif;
	static ArrayList<Dot> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		while (true) {
			boolean flag = false;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						if (bfs(i, j))
							flag = true;

					}
				}
			}
			if (!flag) {
				break;
			}
			result++;
		}
		System.out.println(result);
	}

	static boolean bfs(int x, int y) {
		boolean check = false;
		Queue<Dot> q = new LinkedList<Dot>();
		q.offer(new Dot(x, y));
		int sum = map[x][y];
		int cnt = 1;
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			visit[dot.x][dot.y] = true;
			for (int i = 0; i < 4; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];
				if (px >= 0 && px < N && py >= 0 && py < N && !visit[px][py]) {
					int dif = Math.abs(map[dot.x][dot.y] - map[px][py]);
					if (L <= dif && dif <= R) {
						sum += map[px][py];
						cnt++;
						visit[px][py] = true;
						q.offer(new Dot(px, py));
					}
				}
			}
		}
		if (cnt > 1) {
			check = true;
			int move = sum / cnt;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j]) {
						map[i][j] = move;
					}
				}
			}
		}
		return check;
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
