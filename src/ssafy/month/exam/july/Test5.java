package ssafy.month.exam.july;

import java.util.Scanner;

public class Test5 {
	static int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 };// 상 하 우,좌 ,오른대각 위,왼 대각 아래,오른대각 아래 ,왼대각 위
	static int[] dy = { 0, 0, 1, -1, 1, -1, -1, 1 };
	static boolean[][] visit;
	static int[][] map;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[20][20];
		visit = new boolean[20][20];
		System.out.println("test5");
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (map[i][j] != 0) {
					cnt++;
					search(map[i][j], i, j);

				}
			}
		}

	}

	static int search(int colorEgg, int x, int y) {
		for (int i = 0; i < 8; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if (1 <= px && 20 > px && 1 <= py && 20 > py) {
				if (map[px][py] == colorEgg) {
					cnt++;
					search2(colorEgg, px, py,dx[i],dy[i]);
				}

			}
		}

		return 1;

	}

	 static void search2(int colorEgg, int px, int py, int i, int j) {//기준점에서 
		
		
	}

}
