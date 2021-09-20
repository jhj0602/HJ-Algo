package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600_말이되고픈원숭이 {
	static int[][] map, dist;
	static boolean[][] visit;
	static ArrayList<Dot> list = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	static int k, w, h;
	static int[] dx = { 0, -1, 0, 1 };// k를 다썻을경우 인접한 네칸
	static int[] dy = { 1, 0, -1, 0 };
	static int[] hx = { -1, -2, -1, -2, 1, 2, 1, 2 };
	static int[] hy = { -2, -1, 2, 1, -2, -1, 2, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visit = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0, 0);
	}

	static void bfs(int x, int y) {
		int res=0;
		Queue<Dot> q = new LinkedList<Dot>();
		dist = new int[h][w];
		dist[0][0] = 0;
		visit[x][y] = true;
		q.offer(new Dot(x, y));
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			  if(dot.x == h-1 && dot.y == w-1) {
	                res = dist[dot.x][dot.y];
	                System.out.println(res);
	                break;
	            }
			if (k > 0) {
				for (int i = 0; i < 8; i++) {
					int px = dot.x + hx[i];
					int py = dot.y + hy[i];
					if (px >= 0 && px < h && py >= 0 && py < w && map[px][py] != 1 && !visit[px][py]) {
						visit[px][py] = true;
						dist[px][py] = dist[dot.x][dot.y] + 1;
						q.offer(new Dot(px, py));
					}
					k--;
				}
			}
			for (int i = 0; i < 4; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];
				if (px >= 0 && px < h && py >= 0 && py < w && map[px][py] != 1 && !visit[px][py]) {
					visit[px][py] = true;
					dist[px][py] = dist[dot.x][dot.y] + 1;
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
