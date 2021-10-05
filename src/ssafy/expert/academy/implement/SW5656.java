package ssafy.expert.academy.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5656 {
	static int N, W, H;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			permutation(0, map);
			sb.append("#" + test_case + " " + min + "\n");
		}
		System.out.println(sb);

	}

	private static void permutation(int cnt, int[][] map) {
		if (cnt == N) {
			min = Math.min(min, getRemain(map));
			return;
		}
		int[][] tempMap = new int[H][W];
		for (int i = 0; i < W; i++) {
			int r = 0;
			while (r < H && map[r][i] == 0)
				r++;

			if (r == H) {// 구슬을 던졌지만 맞은 벽돌이 없는 경우
				permutation(cnt + 1, map);// 다음 구슬 던지기
			} else {// 맞은 벽돌이 있는경우

				// 이전 cnt 까지의 map에 상태를 복사해서 사용
				copy(map, tempMap);
				// 맞은 벽돌 및 주변 벽돌 함께 제거 처리
				boom(tempMap, r, i);
				// 제거된 벽돌들 내리기
				down(tempMap);
				// 다음 구슬 던지기
				permutation(cnt + 1, tempMap);
			}

		}
	}

	private static int getRemain(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static ArrayList<Integer> list = new ArrayList<Integer>();

	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			int r;
			for (r = H - 1; r >= 0; --r) {
				if (map[r][c] > 0) {
					list.add(map[r][c]);
					map[r][c] = 0;
				}
			}
			// 리스트에 있는 벽돌 제일 아래 행부터 채우기
			r = H - 1;
			for (int b : list) {
				map[r--][c] = b;

			}
			list.clear();
		}

	}

	private static void boom(int[][] map, int r, int c) {
		// BFS 로 함께 부숴질 벽돌 처리
		Queue<Dot> q = new LinkedList<Dot>();
		if (map[r][c] > 1) {// 벽돌의 숫자가 1보다 클때만 넣는다
			q.offer(new Dot(r, c, map[r][c]));
		}
		map[r][c] = 0;// 벽돌제거
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			for (int i = 0; i < 4; i++) {// 한방향씩 조지겠다
				int px = dot.x;
				int py = dot.y;

				for (int j = 1; j < dot.num; j++) { // num-1 만큼 돌기
					px += dx[i];
					py += dy[i];
					if (px >= 0 && px < H && py >= 0 && py < W && map[px][py] != 0) {
						if (map[r][c] > 1) {// 벽돌의 숫자가 1보다 클때만 넣는다
							q.offer(new Dot(px, py, map[px][py]));
						}
						map[px][py] = 0;
					}
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] tempMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tempMap[i][j] = map[i][j];
			}
		}

	}

	static class Dot {
		int x;
		int y;
		int num;

		public Dot(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

}
