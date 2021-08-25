package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236_아기상어 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] map;
	static int[][] dist;
	static int N;
	static Dot babyShark;// 아기 상어 위치
	static int sharkSize = 2;
	static int minX;
	static int minY;
	static int minDist;
	static int time = 0;// 시간계산
	static int eatCnt = 0;// 상어가 먹은갯수
	private static int sharkX = -1;
	private static int sharkY = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}
		while (true) {
			dist = new int[N][N];
			minX = Integer.MAX_VALUE;
			minY = Integer.MAX_VALUE;
			minDist = Integer.MAX_VALUE;
//			System.out.println(babyShark.x + "  " + babyShark.y);
			bfs(sharkX, sharkY);
			if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				eatCnt++;
				map[minX][minY] = 0;
				sharkX = minX;
				sharkY = minY;
				time += dist[minX][minY];

				if (eatCnt == sharkSize) {
					sharkSize++;
					eatCnt = 0;
				}
			} else {
				break;
			}
		}
		System.out.println(time);
	}

	private static void bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<>();
		q.offer(new Dot(x, y));
		while (!q.isEmpty()) {
			Dot current = q.poll();
			for (int i = 0; i < 4; i++) {
				int px = current.x + dx[i];
				int py = current.y + dy[i];
				if (px >= 0 && py >= 0 && px < N && py < N && map[px][py] <= sharkSize && dist[px][py] == 0) {
					if (map[px][py] != 0 && map[px][py] < sharkSize) {
						if (dist[px][py] < minDist) {
							minDist = map[px][py];
							minX = px;
							minY = py;
						} else if (dist[px][py] == minDist) {// 같으면 이동만 해준다.
							if (minX == px) {
								if (minY > py) {
									minX = px;
									minY = py;
								}
							} else if (minX > px) {
								minX = px;
								minY = py;
							}
						}
					}
					q.add(new Dot(px, py));
				}
			}
		}
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
