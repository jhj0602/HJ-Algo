package ssafy.expert.academy.implement;

import java.util.Scanner;

public class Building {
	private static String src = "3 6 G B G G B B G B G G B G B B B B G B B G B B B B G B B B B G G B B B B G 5 G B G G B G B G G B  B B B B G B G B B B G B B B B 3 G G B G B B B B B\r\n"
			+ "";
	static int[] dx = { -1, 1, 0, 0, 1, -1, 1, -1 };
	static int[] dy = { 0, 0, -1, 1, 1, -1, -1, 1 };
	static int height;
	static int N;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sc = new Scanner(src);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new char[N][N];
			height = 0;

			//// 1.입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'B') {
						search(i, j);
					}
				}
			}
			sb.append(height+"\n");

		}
		System.out.println(sb);
	}

	static void search(int x, int y) {
		boolean existG = false;
		for (int i = 0; i < 8; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if (px >= 0 && py >= 0 && px < N && py < N) {
				if (map[px][py] == 'G')
					existG = true;
			}
		}
		if (existG) {
			height = Math.max(height, 2);
			return;
		} else {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if(map[i][y]=='B') {
					cnt++;
				}
			}
			for (int i = 0; i < N; i++) {
				if(map[x][i]=='B') {
					cnt++;
				}
			}
			height = Math.max(height, cnt-1);
			return;
		}

	}
}
