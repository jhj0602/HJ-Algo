package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1194 {
	static int n, m;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<Dot> list;
	static HashMap<Character, Character> hashMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		list = new ArrayList<>();// 도달지점
		hashMap = new HashMap<>();

		int minsickX = 0;
		int minsickY = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 0) {
					minsickX = i;
					minsickY = j;
					map[i][j] = '.';
				} else if (map[i][j] == 1) {
					list.add(new Dot(i, j));
				}
			}
		}

		System.out.println(bfs(minsickX, minsickY));

	}

	static int bfs(int x, int y) {
		int[][] dist = new int[n][m];
		visit = new boolean[n][m];
		Queue<Dot> q = new LinkedList<Dot>();
		int time = 0;
		q.offer(new Dot(x, y));
		while (!q.isEmpty()) {
			time++;
			Dot dot = q.poll();
			for (int i = 0; i < 4; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];
				if (px >= 0 && px < n && py >= 0 && py < m && map[px][py] != '#' && !visit[px][py]) {
					boolean flag = false;
					if (map[px][py] == '1')
						return time;
					if (Character.isLetterOrDigit(map[px][py]) || map[px][py] == '.') {// 숫자이거나 . 이면 가자
						flag = true;
					} else {
						if (Character.isLowerCase(map[px][py])) {// 알파벳 소문자면 mapkey 삽입
							System.out.println("zzz");
							hashMap.put((char)(map[px][py] - 32), map[px][py]);

							flag = true;
						} else if (Character.isUpperCase(map[px][py])) {// 대문자면
							if (hashMap.containsKey(map[px][py])) {
								flag = true;
							}
						}
					}
					if (flag) {
						visit[px][py] = true;
						q.offer(new Dot(px, py));
					}
				}
			}
		}
		return -1;
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
