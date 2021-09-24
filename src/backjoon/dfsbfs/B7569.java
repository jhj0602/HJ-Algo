package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 {

	static int[][][] map;
	static int[] dx = { 0, -1, 0, 1, 0, 0 };
	static int[] dy = { 1, 0, -1, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int n, m, h;
	static Queue<Dot> q;
	static int zero = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[n][m][h];
		q = new LinkedList<>();
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					map[i][j][k] = Integer.parseInt(str[j]);
					if (map[i][j][k] == 1) {
						q.offer(new Dot(i, j, k));
					}
					if (map[i][j][k] == 0)
						zero++;
				}
			}
		}
		if (zero == 0) {
			System.out.println(max);
		} else {
			bfs();

			if (zero > 0) {
				System.out.println(-1);
			} else {
				System.out.println(max - 1);
			}
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			for (int i = 0; i < 6; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];
				int pz = dot.z + dz[i];
				if (px < n && px >= 0 && py < m && py >= 0 && pz < h && pz >= 0 && map[px][py][pz] == 0) {
					map[px][py][pz] = map[dot.x][dot.y][dot.z] + 1;
					q.offer(new Dot(px, py, pz));
					max = Math.max(max, map[px][py][pz]);
					zero--;
				}
			}
		}

	}

	static class Dot {
		int x;
		int y;
		int z;

		public Dot(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

}
