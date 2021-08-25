package ssafy.onlin_learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인접행렬TEST {
	static int N;
	static boolean[][] adjMatrix;// 인접행렬 (가중치 없음)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[N][N];

		int C = Integer.parseInt(br.readLine());

		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] = true;// 그래프 정보를 인접 행렬로 입력받음
		}
		boolean[] visited = new boolean[N];
		visited[0] = true;
		System.out.println("dfs");
		dfs(0, visited);
		System.out.println("bfs");
		bfs();
	}

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.println((char) (current + 65));
		for (int i = 0; i < N; i++) {
			if (!visited[i] && adjMatrix[current][i]) {
				visited[i] = true;
				dfs(i, visited);
			}
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		q.offer(0);
		visited[0] = true;
		while (!q.isEmpty()) {
			int current = q.poll();
			System.out.println((char) (current + 65));
			for (int i = 0; i < N; i++) {
				if (!visited[i]// 방문하지 않은정점
						&& adjMatrix[current][i]) {// 인접정점인지 확인하는것
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}
