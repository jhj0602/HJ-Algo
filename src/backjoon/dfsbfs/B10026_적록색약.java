package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10026_적록색약 {
	static int N;
	static char[][] arr;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visit;
	static Queue<dot> q = new LinkedList<dot>();
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		search();
		System.out.print(count + " ");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}
		search();
		System.out.print(count);
	}

	private static void search() {
		count = 0;
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
	}

	static void bfs(int x, int y) {
		char temp = arr[x][y];
		visit[x][y] = true;
		q.offer(new dot(x, y));
		while (!q.isEmpty()) {
			dot dot = q.poll();
			for (int i = 0; i < 4; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];
				if (px >= 0 && px < N && py >= 0 && py < N && arr[px][py] == temp && !visit[px][py]) {
					visit[px][py] = true;
					q.offer(new dot(px, py));
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
