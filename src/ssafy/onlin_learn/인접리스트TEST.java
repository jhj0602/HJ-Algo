package ssafy.onlin_learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인접리스트TEST {
	static class Node {// 인접정점의 인덱스
		int vertex;
		Node link;

		public Node(int vertex, Node link) {

			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}

	static int N;
	static Node[] adjList;// 인접리스트 (가중치 없음)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjList = new Node[N];

		int C = Integer.parseInt(br.readLine());

		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		boolean[] visited = new boolean[N];
		System.out.println("dfs");
		dfs(0, visited);
		System.out.println("bfs");
		bfs();
	}

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.println((char) (current + 65));
		for (Node temp = adjList[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex])// 방문하지 않은정점
			{
				visited[temp.vertex] = true;
				dfs(temp.vertex, visited);
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
			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex])// 방문하지 않은정점
				{
					q.offer(temp.vertex);
					visited[temp.vertex] = true;
				}

			}
		}
	}

}