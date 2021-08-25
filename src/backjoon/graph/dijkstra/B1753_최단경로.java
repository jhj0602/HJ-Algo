package backjoon.graph.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken()) + 1;
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		int end = V - 1;
		final int INFINITY = Integer.MAX_VALUE;

		int[][] matrix = new int[V][V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			matrix[u][v] = w;
		}

		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		int min = 0, current = 0;
		for (int i = 1; i < V; i++) {
			min = INFINITY;
			for (int j = 1; j < V; j++) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			if (current == end) {
				break;
			}

			for (int c = 1; c < V; ++c) {
				if (!visited[c] && matrix[current][c] != 0 && distance[c] > min + matrix[current][c]) {
					distance[c] = min + matrix[current][c];
				}
			}
			sb.append(distance[i] < Integer.MAX_VALUE ? distance[i] + "\n" : "INF\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
