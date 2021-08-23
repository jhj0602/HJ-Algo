package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFSBFS {
	static int N, M;
	static boolean[] visited;
	static boolean[][] adjMatrix;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		adjMatrix = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = true;
			adjMatrix[to][from] = true;
		}
		visited = new boolean[N];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N];
		bfs(V);
		System.out.println(sb);
	}

	private static void dfs(int v) {
		System.out.println("Zzz");
		visited[v] = true;
		sb.append(v + " ");
		for (int i = 0; i < N; i++) {
			if (!visited[v] && adjMatrix[v][i]) {
				visited[i] = true;
				dfs(i);
			}
		}

	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		visited[v] = true;
		sb.append(v + " ");
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
