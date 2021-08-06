package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SW1861 {
	static int N;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<RoomCount> list;
	static int dfsCount;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfsCount = 1;
					dfs(i, j);
					list.add(new RoomCount(map[i][j], dfsCount));
				}
			}
			Collections.sort(list, new Comparator<RoomCount>() {
				@Override
				public int compare(RoomCount o1, RoomCount o2) {
					return o2.count - o1.count;
				}
			});
			int maxValue = list.get(0).count;
			int min = N * N;
			for (RoomCount i : list) {
				if (i.count != maxValue)
					break;
				min = Math.min(i.num, min);
			}
			sb.append("#" + test_case + " " + min + " " + maxValue + "\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		for (int k = 0; k < 4; k++) {
			int px = x + dx[k];
			int py = y + dy[k];
			if (0 <= px && px < N && 0 <= py && py < N) {
				if (map[px][py] == map[x][y] + 1) {
					dfsCount++;
					dfs(px, py);
				}
			}
		}
		return;
	}

	static class RoomCount {
		int num;
		int count;
		public RoomCount(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
}
