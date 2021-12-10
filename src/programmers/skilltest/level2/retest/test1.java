package programmers.skilltest.level2.retest;

import java.util.Arrays;

public class test1 {
	static int[] dx = { 0, 0, 1, -1 };// 상 하 우 좌
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
	}

	public static int solution(String dirs) {
		int answer = 0;
		boolean visit[][][][] = new boolean[11][11][11][11];
		int cX = 5;
		int cY = 5;
		int dir = 0;
		for (int i = 0; i < dirs.length(); i++) {
			if (dirs.charAt(i) == 'U') {
				dir = 0;
			} else if (dirs.charAt(i) == 'D') {
				dir = 1;
			} else if (dirs.charAt(i) == 'R') {
				dir = 2;
			} else if (dirs.charAt(i) == 'L') {
				dir = 3;
			}
			int nx = cX + dx[dir];
			int ny = cY + dy[dir];
			if (ny < 0 || nx < 0 || ny >= 11 || nx >= 11)
				continue;
			if (!visit[cX][cY][nx][ny] == true && !visit[nx][ny][cX][cY] == true) {
				visit[cX][cY][nx][ny] = true;
				visit[nx][ny][cX][cY] = true;
				answer++;
			}
			cX = nx;
			cY = ny;
			System.out.println(Arrays.deepToString(visit));
		}
		return answer;
	}
}
