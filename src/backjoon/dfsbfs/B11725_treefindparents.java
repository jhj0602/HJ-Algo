package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11725_treefindparents {
	static int N, M;
	static boolean[] visited;
	static boolean[][] adjMatrix;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
	}


	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		visited[v] = true;
		sb.append(v + "\n");
		q.offer(v);
		while (!q.isEmpty()) {
			int current = q.poll();
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[current][i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}

	}
}
