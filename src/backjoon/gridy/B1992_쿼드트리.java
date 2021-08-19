package backjoon.gridy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1992_쿼드트리 {

	private static int n;
	private static int map[][];
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		n = Integer.valueOf(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		divide(0, 0, n);
		System.out.println(sb);
	}

	private static void divide(int r, int c, int size) {// 행 열 크기
	
		// 같은색인지 체크
		if (check(r, c, size)) {
			sb.append(map[r][c]);
		} else {// 색이 섞여 있음
				// 4분할하여 각각의 사각형 처리
			int half = size / 2;
			sb.append("(");
			divide(r, c, half);// 1사분면 가리키는 매개변수
			divide(r, c + half, half);// 2사분면
			divide(r + half, c, half);// 3사분면
			divide(r + half, c + half, half);// 4사분면
			sb.append(")");
		}
	}

	// 동일한 숫자 있는지 체크
	private static boolean check(int x, int y, int n) {// 행 열 n
		int num = map[x][y];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (num != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
//	private static void quadtree(int x, int y, int n) {//2제곱만큼 돌려줌
//		if (check(x, y, n)) {
//			sb.append(map[x][y]);
//		} else {
//			sb.append("(");
//			int idx = n / 2;
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 2; j++) {
//					quadtree(x + idx * i, y + idx * j, idx);
//				}
//			}
//			sb.append(")");
//		}
//	}
}
