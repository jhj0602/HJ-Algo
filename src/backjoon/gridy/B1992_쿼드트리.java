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
		quadtree(0, 0, n);
		System.out.println(sb);
	}
	//동일한 숫자 있는지 체크
	private static boolean check(int x, int y, int n) {//행 열 n
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
	private static void quadtree(int x, int y, int n) {//2제곱만큼 돌려줌
		if (check(x, y, n)) {
			sb.append(map[x][y]);
		} else {
			sb.append("(");
			int idx = n / 2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					quadtree(x + idx * i, y + idx * j, idx);
				}
			}
			sb.append(")");
		}
	}
}
