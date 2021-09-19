package programmers.kakao.intern2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test2 {
	static ArrayList<Dot> list;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		solution(places);

	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[5];

		for (int i = 0; i < 5; i++) {
			map = new char[5][5];
			String[] str = places[i];
			list = new ArrayList<>();// list 초기화
			for (int j = 0; j < 5; j++) {
				String temp = str[j];
				for (int k = 0; k < 5; k++) {
					map[j][k] = temp.charAt(k);
					if (map[j][k] == 'P') {
						list.add(new Dot(j, k));
					}
				}
			}
			visit = new boolean[5][5];
			if (list.size() == 0) {
				answer[i] = 1;
			} else {
				boolean flag = true;
				for (int j = 0; j < list.size(); j++) {
					if (!bfs(list.get(j).x, list.get(j).y)) {
						answer[i] = 0;
						flag = false;
						break;
					}
				}
				if (flag)
					answer[i] = 1;
			}

		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	private static boolean bfs(int x, int y) {
		Queue<Dot> queue = new LinkedList<>();
		queue.add(new Dot(x, y));
		boolean checker = true;
		visit[x][y] = true;
		int[][] dist = new int[5][5];
		dist[x][y] = 0;
		while (!queue.isEmpty()) {
			Dot dot = queue.poll();
			if (dist[dot.x][dot.y] >= 2) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int px = dot.x + dx[i];
				int py = dot.y + dy[i];
				if (px >= 0 && px < 5 && py >= 0 && py < 5) {
					if (!visit[px][py]) {
						if (map[px][py] == ('O')) {
							queue.add(new Dot(px, py));
							dist[px][py] = dist[dot.x][dot.y] + 1;
						} else if (map[px][py] == ('P')) {
							if (dist[px][py] <= 2) {
								checker = false;
								break;
							}
						}
					}
				}
			}
			if (!checker) {
				return false;
			}
		}
		for (int i = 0; i < visit.length; i++) {
			Arrays.fill(visit[i], false);
		}
		return true;
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
