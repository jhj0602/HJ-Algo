package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2563 {
	static int maxCount = 0;
	static int[][] arr;
	static boolean[][] visit = new boolean[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[101][101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			drawing(x, y);
		}
		System.out.println(maxCount);
	}

	private static void drawing(int x, int y) {
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				arr[i][j] = 1;
				if (!visit[i][j]) {
					maxCount++;
					visit[i][j] = true;
					continue;
				}

			}
		}
	}

}
