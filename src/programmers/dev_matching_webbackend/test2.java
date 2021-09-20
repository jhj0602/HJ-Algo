package programmers.dev_matching_webbackend;

import java.util.Arrays;
import java.util.PriorityQueue;

public class test2 {
	static int[][] map;

	public static void main(String[] args) {
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
		System.out.println(Arrays.toString(solution(6, 6, queries)));
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int cnt = 1;
		map = new int[rows + 1][columns + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = cnt;
				cnt++;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			answer[i] = rotation(query[0], query[1], query[2], query[3]);
		}
		return answer;
	}

	public static int rotation(int x1, int y1, int x2, int y2) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int temp = map[x1][y1];

		int min = temp;
		for (int i = x1; i < x2; i++) {// 아래쪽
			map[i][y1] = map[i + 1][y1];

			min = Math.min(min, map[i][y1]);
		}

		for (int i = y1; i < y2; i++) {// 오른쪽
			map[x2][i] = map[x2][i + 1];

			min = Math.min(min, map[x2][i]);
		}

		for (int i = x2; i > x1; i--) {// 위쪽
			map[i][y2] = map[i - 1][y2];

			min = Math.min(min, map[i][y2]);
		}

		for (int i = y2; i > y1; i--) {// 왼쪽
			map[x1][i] = map[x1][i - 1];
			System.out.print(i + " " + y1 + " " + map[i][y1] + " ");
			min = Math.min(min, map[x1][i]);
		}
		System.out.println();
		map[x1][y1 + 1] = temp;

		return min;

	}

}
