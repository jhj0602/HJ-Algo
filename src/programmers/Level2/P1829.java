package programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class P1829 {
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visit;

	public static void main(String[] args) {
		P1829 p = new P1829();
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		p.solution(6, 4, picture);

	}

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = Integer.MIN_VALUE;
		visit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && picture[i][j] != 0) {
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture, m, n));
				}
			}

		}
		System.out.println(numberOfArea + " " + maxSizeOfOneArea);
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public int bfs(int i, int j, int[][] picture, int m, int n) {
		int temp = picture[i][j];
		int size = 1;
		Queue<Dot> q = new LinkedList<>();
		q.offer(new Dot(i, j));
		visit[i][j] = true;
		while (!q.isEmpty()) {
			Dot dot = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = dot.x + dx[k];
				int ny = dot.y + dy[k];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n ) {
					if (temp == picture[nx][ny]&&!visit[nx][ny]) {
						q.offer(new Dot(nx, ny));
						visit[nx][ny] = true;
						size++;
					}
				}
			}
		}
		return size;
	}

	static class Dot {
		int x;
		int y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
