package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B2615 {
	static int[] dx = { 1, 1, 0, -1 };// 상 하 우,좌 ,오른대각 위,왼 대각 아래,오른대각 아래 ,왼대각 위
	static int[] dy = { 0, 1, 1, 1 };
	static boolean[][] visit;
	static int[][] map;
	static int cnt = 0;
	static int[][] leftValue;
	static int indexX;
	static int indexY;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[20][20];
		visit = new boolean[20][20];
		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (map[i][j] != 0) {
					leftValue = new int[19][2];
					leftValue[0][0] = i;
					leftValue[0][1] = j;
					cnt = 1;
					search(map[i][j], i, j);
					if (cnt == 5) {
						System.out.println(map[i][j]);


					}

				}
			}
		}
		System.out.println(0);

	}

	static void search(int colorEgg, int x, int y) {

		for (int i = 0; i < 8; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if (1 <= px && 20 > px && 1 <= py && 20 > py) {
				if (map[px][py] == colorEgg) {
					cnt++;
					search2(colorEgg, px, py, dx[i], dy[i]);

					indexX = dx[i];
					indexY = dy[i];
					break;
				}

			}
		}

	}

	static boolean search2(int colorEgg, int px, int py, int i, int j) {// 기준점에서
		leftValue[cnt - 1][0] = px;
		leftValue[cnt - 1][1] = py;
		px = px + i;
		py = py + j;
		if (1 <= px && 20 > px && 1 <= py && 20 > py) {
			if (map[px][py] == colorEgg) {
				cnt++;
				System.out.println("cnt" + cnt);
				search2(colorEgg, px, py, i, j);
			}
		}
		return false;

	}

	static String indexToString() {
		// 1,1 1,-1
		if (indexX == 1 && indexY == -1) {
			return leftValue[4][0] + " " + leftValue[4][1];
		}
		return leftValue[0][0] + " " + leftValue[0][1];
	}

}
