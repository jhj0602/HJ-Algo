package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14890 {
	static int[][] map;
	static boolean[][] visit;// 경사로를 놓은곳에는 또 놓을수 없다.
	static int n, l;

	// 오른쪽으로 갈거
	// 아래쪽을 갈거
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		int cnt = 0; // 길의 갯수
		for (int i = 1; i <= n; i++) {// 오른쪽으로 갈꺼
			int tempCnt = 0;// 이게 n이 되면 cnt++
			for (int j = 1; j < n; j++) {
				if (map[i][j] == map[i][j + 1]) {
					tempCnt++;
					continue;
				}
				if (Math.abs(map[i][j] - map[i][j + 1]) == 1) {// 차이가 1
					if (!rightCheck(i, j)) {// 경사로 체크
						System.out.println(i);
						break;
					}
					tempCnt++;
				} else if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {// 차이가 2
					System.out.println(i);
					break;
				}
			}
			if (tempCnt == n - 1) {
				cnt++;
			}
		}
		System.out.println("cnt" + cnt);

	}

	private static boolean rightCheck(int x, int y) {// 오른쪽으로 가는거

		if (y - l > 0 && y + l < n + 1) {
	
				if (map[x][y] > map[x][y + 1]) {// 아래로 경사로
					int temp = map[x][y + 1];// 경사질때 아래 있는 값
					for (int i = 1; i < l; i++) {
						if (temp != map[x][y + i] && !visit[x][y + i]) {
							return false;
						}
System.out.println("zz");
						visit[x][y + i] = true;
					}
				} else {// 위로 경사로
					int temp = map[x][y];
					for (int i = 0; i < l; i++) {
						if (temp != map[x][y - i] && !visit[x][y - i]) {
							return false;
						}
						visit[x][y - i] = true;
					}

				}
				return true;
			}
			
		
		return false;
	}

}
