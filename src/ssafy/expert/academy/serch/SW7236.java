package ssafy.expert.academy.serch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SW7236 {
	static int[] dx = { 1, -1, 0, 0, -1, 1, 1 ,- 1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			ArrayList<Dot> list = new ArrayList<Dot>();
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine().replaceAll(" ", "");
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'W') {
						list.add(new Dot(i, j));
					}
				}
			}
			int max = 0;
			for (int i = 0; i < list.size(); i++) {
				int cnt = 0;
				for (int j = 0; j < 8; j++) {
					int px = list.get(i).x+dx[j];
					int py = list.get(i).y+dy[j];
				System.out.println("zzzz");
					if (px >= 0 && px < N && py >=0 && py < N) {
						if (map[px][py] == 'W') {
							cnt++;
						}
					}

				}
				
				if (cnt == 0) {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
			sb.append("#"+test_case+" "+max+"\n");
		}
		System.out.println(sb);

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
