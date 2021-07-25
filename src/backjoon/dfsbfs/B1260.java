package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
	static int[][] map;
	static boolean[] visit;
	static int n, m, v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		int num1, num2;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			map[num1][num2] = map[num2][num1] = 1;

		}
		dfs(v);
		visit = new boolean[n + 1];
		sb.append("\n");
		bfs(v);
		System.out.println(sb);

	}

	public static void ResetVisit() {
		for (int i = 1; i < n + 1; i++) {
			visit[i] = false;
		}
		System.out.println();
	}

	public static void dfs(int d) {
		visit[d] = true;
		sb.append(d + " ");
		for (int i = 1; i < n + 1; i++) {
			if (map[d][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int b) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(b);
		visit[b] = true;
		while (!queue.isEmpty()) {
			b = queue.poll();
			sb.append(b + " ");
			for (int i = 1; i < n + 1; i++) {
				if (map[b][i] == 1 && !visit[i]) {
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}

}
