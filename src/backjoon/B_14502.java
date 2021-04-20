package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14502 {
	static class dotVirus {
		int x, y;

		public dotVirus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int N, M;
	static int safeResult = 0;
	static int[][] area;
	static int[][] areaCopy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		area = new int[N][M];
		areaCopy = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		setWall(0);
		System.out.println(safeResult);

	}

	static void setWall(int wall) {
		if (wall == 3) {
			spreadVirus();
			safeResult = Math.max(safeResult, safeCount());
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (area[i][j] == 0) {
					area[i][j] = 1;
					setWall(wall + 1);
					area[i][j] = 0;
				}

			}
		}

	}

	static int safeCount() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (areaCopy[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	static void spreadVirus() {
		Queue<dotVirus> q = new LinkedList<dotVirus>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				areaCopy[i][j] = area[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (areaCopy[i][j] == 2) {
					q.add(new dotVirus(i, j));
				}

			}
		}
		while (!q.isEmpty()) {
			dotVirus v = q.poll();
			for (int i = 0; i < 4; i++) {
				int px = v.x + dx[i];
				int py = v.y + dy[i];
				if (px >= 0 && py >= 0 && px < N && py < M) {

					if (areaCopy[px][py] == 0) {
						areaCopy[px][py] = 2;
						q.add(new dotVirus(px, py));
					}
				}
			}
		}

	}

}
