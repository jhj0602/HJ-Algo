package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2239_스도쿠 {
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for (int i = 1; i <= 9; i++) {
			String[] str = br.readLine().split("");
			for (int j = 1; j <= 9; j++) {
				map[i][j] = Integer.parseInt(str[j - 1]);
			}
		}
		for (int i = 1; i <= 9; i += 3) {
			for (int j = 1; j <= 9; j += 3) {
				sdoku(i, j);
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void sdoku(int x, int y) {
		// 안에 3*3배열 안에 무슨숫자가 있는지 검사
		// 안에 3*3배열 안에 무슨숫자가 있는지 검사
		boolean[] isNumber = new boolean[10];
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (map[i][j] != 0) {
					isNumber[map[i][j]] = true;
				}
			}
		}
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (map[i][j] == 0) {// 숫자를 넣을수 있는 공간이라면
					
					for (int k = 1; k < 10; k++) {
						if (!isNumber[k] && isVertical(i, j,k) && isHorizontal(i, j,k)) {
							System.out.print(k);
							map[i][j] = k;
							isNumber[k]=true;
							break;
						}
					}
				}
			}
		}
		System.out.println();
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

//	private static boolean isSqare(int x, int y, int k) {
//		for (int i = x; i < x + 3; i++) {
//			for (int j = y; j < y + 3; j++) {
//				if (map[i][j] == k) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}

	private static boolean isVertical(int x, int y, int k) {
		for (int i = 1; i <= 9; i++) {
			if (map[i][y] == k) {
				return false;
			}
		}
		return true;
	}

	private static boolean isHorizontal(int x, int y, int k) {
		for (int i = 1; i <= 9; i++) {
			if (map[x][i] == k) {
				return false;
			}
		}
		return true;
	}

}
