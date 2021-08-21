package backjoon.exhaustive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1987_알파벳 {
	static int[] dx = { -1, 1, 0, 0 };// 하 싱 좌 우
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[] isAlpa;// 알파벳 확인 배열 사용했다면 true아니면 false
	static char[][] arr;
	static int R, C;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str[j];
			}
		}

		isAlpa = new boolean[26];
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int x, int y, int cnt) {
		max = Math.max(max, cnt);
		isAlpa[arr[x][y] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if (0 <= px && R > px && 0 <= py && C > py && !isAlpa[arr[px][py] - 'A']) {
				dfs(px, py, cnt + 1);
			}
		}
		isAlpa[arr[x][y] - 'A'] = false;

	}

}
