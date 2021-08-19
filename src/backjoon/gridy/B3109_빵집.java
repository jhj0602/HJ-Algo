package backjoon.gridy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3109_빵집 {
	static int R, C;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int count = 0;
		for (int i = 0; i < R; i++) {
			if (backTracking(i, 0)) {
				count++;
				System.out.println("되는 열 "+i);
			}else {
				System.out.println("안되는 열 "+i);
			}
		}
		System.out.println(count);
	}

	static boolean backTracking(int x, int y) {
		map[x][y] = 'x';// 갔던 곳은 방문 못하게 해야함
		if (y == C - 1) {// 빵집 도착 바로 리턴
			return true;
		}
		if (x > 0 && map[x - 1][y + 1] == '.') { // 오른쪽 위
			System.out.println("오른쪽 위");
			if (backTracking(x - 1, y + 1)) {
				return true;
			}
		}
		if (map[x][y + 1] == '.') {// 오른쪽
			System.out.println("오른쪽 ");
			if (backTracking(x, y + 1)) {
				return true;
			}
		}
		if (x + 1 < R && map[x + 1][y + 1] == '.') { // 오른쪽 아래
			System.out.println("오른쪽 아래");
			if (backTracking(x + 1, y + 1)) {
				return true;
			}
		}
		return false;
	}
}
