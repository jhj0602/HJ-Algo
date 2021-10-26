package AlgoHot6.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17141_연구소2 {
	static int n, m, count, map[][];
	static boolean[][] visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int wallCount = 0;
	static int min = Integer.MAX_VALUE;
	static int[] temp;
	static ArrayList<Dot> vIdx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		temp = new int[m];
		vIdx = new ArrayList<>();// 바이러스 지점
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					map[i][j] = 0;
					vIdx.add(new Dot(i, j));
				} else {
					if (num == 1) {
						wallCount++;
					}
					map[i][j] = num;
				}
			}
		}
		if (m != n * n - wallCount) {
			comb(0, 0);
			System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		} else {
			System.out.println(0);
		}

	}

	private static void comb(int cnt, int start) {
		if (cnt == m) {
			visit = new boolean[n][n];
			min = Math.min(min, bfs(temp));
			return;
		}
		for (int i = start; i < vIdx.size(); i++) {
			temp[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}

	static int bfs(int[] temp) {
		int time = -1;
		int spreadCount = 0;
		Queue<Dot> q = new LinkedList<>();
		for (int i = 0; i < temp.length; i++) {
			spreadCount++;
			Dot virus = vIdx.get(temp[i]);
			q.offer(new Dot(virus.x, virus.y));
			visit[virus.x][virus.y] = true;
		}
		while (!q.isEmpty()) {
			time++;
			int wSize = q.size();
			for (int i = 0; i < wSize; i++) {
				Dot currentW = q.poll();
				for (int j = 0; j < 4; j++) {
					int px = currentW.x + dx[j];
					int py = currentW.y + dy[j];
					if (px >= 0 && px < n && py >= 0 && py < n && map[px][py] != 1 && !visit[px][py]) {
						spreadCount++;
						visit[px][py] = true;
						q.offer(new Dot(px, py));
					}
				}
			}
		}
		if (spreadCount != n * n - wallCount)
			return Integer.MAX_VALUE;
		else
			return time != 0 ? time : Integer.MAX_VALUE;
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
