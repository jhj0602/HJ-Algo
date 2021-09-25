package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17144 {
	static int[][] map;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int r, c;
	static int[] cleaner = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		map = new int[r][c];

		int idx = 0;
		for (int i = 0; i < r; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == -1) {
					cleaner[idx++] = i;
				}

			}
		}
		for (int i = 0; i < t; i++) {
			dustSpread();
			dustClean();

		}
		System.out.println(printSum());
	}

	static int printSum() {
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0)
					sum += map[i][j];
			}
		}
		return sum;
	}

	private static void dustClean() {
		int top = cleaner[0];
		int down = cleaner[1];
		// 반시계 방향
		// 1. 왼쪽 상->하 , 2.위쪽)오른쪽->왼쪽 , 3.오른쪽)하->상, 4.아래쪽)왼쪽->오른쪽
		for (int i = top - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int i = 1; i < c; i++) {
			map[0][i - 1] = map[0][i];
		}
		for (int i = 1; i <= top; i++) {
			map[i - 1][c - 1] = map[i][c - 1];
		}
		for (int i = c - 1; i > 0; i--) {
			map[top][i] = map[top][i - 1];
		}
		// 공기청정기 위치에 있는 애 공기없애기
		map[top][1] = 0;
		// 아래 시계방향
		for (int i = down + 1; i < r - 1; i++) {// 상) 아래->위
			map[i][0] = map[i + 1][0];
		}
		for (int i = 1; i < c; i++) {// 좌) 아래 오른쪽->왼쪽
			map[r - 1][i - 1] = map[r - 1][i];
		}
		for (int i = r - 1; i >= down + 1; i--) {// 하) 위->아래
			map[i][c - 1] = map[i - 1][c - 1];
		}
		for (int i = c - 1; i > 1; i--) {// 우)왼쪽->오른쪽
			map[down][i] = map[down][i - 1];
		}

		map[down][1] = 0;

	}

	private static void dustSpread() {
		Queue<Dot> q = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 4) // 5부터 퍼질수 있어서
					q.add(new Dot(i, j, map[i][j]));
			}
		}
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			int cnt = 0;
			int amount = dot.amount / 5;
			for (int i = 0; i < 4; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];

				if (px < r && px >= 0 && py < c && py >= 0 && map[px][py] != -1) {
					map[px][py] = map[px][py] + amount;
					cnt++;
				}
			}
			map[dot.x][dot.y] = map[dot.x][dot.y] - (amount * cnt);

		}

	}

	static class Dot {
		int x;
		int y;
		int amount;

		public Dot(int x, int y, int amount) {
			this.x = x;
			this.y = y;
			this.amount = amount;
		}
	}

}
