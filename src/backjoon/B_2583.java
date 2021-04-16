package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2583 {
	static int M;
	static int N;
	static int squareArr[][];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int area;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		squareArr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				squareArr[i][j] = 0;
			}
		}

		int[] left = new int[2];
		int[] right = new int[2];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			left[0] = Integer.parseInt(st.nextToken());
			left[1] = Integer.parseInt(st.nextToken());
			right[0] = Integer.parseInt(st.nextToken());
			right[1] = Integer.parseInt(st.nextToken());
			squareDraw(left, right);
		}
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				area = 0;
				if (squareArr[i][j] == 0) {
					count++;
					dfs(i, j);
					list.add(area);
				}
			}
		}
		System.out.println(count);
		list.sort(null);
		for(int i:list) {
			System.out.print(i+" ");
		}

	}

	static void dfs(int x, int y) {
		squareArr[x][y] = 1;
		area++;
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if (0 <= px && M > px && 0 <= py && N > py) {
				if (squareArr[px][py] == 0) {
					dfs(px, py);
				}

			}
		}
	}

	static void squareDraw(int[] left, int[] right) {
		for (int i = left[1]; i < right[1]; i++) {
			for (int j = left[0]; j < right[0]; j++) {
				squareArr[i][j] = 1;
			}
		}

	}

}
