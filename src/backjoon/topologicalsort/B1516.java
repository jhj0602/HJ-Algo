package backjoon.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1516 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] indegree = new int[N + 1];
		int[] timeArr = new int[N + 1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			timeArr[i] = Integer.parseInt(st.nextToken());
			int node = Integer.parseInt(st.nextToken());
			while (node != -1) {
				list.get(node).add(i);
				indegree[i]++;
				node = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
				result[i] = timeArr[i];
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i : list.get(node)) {
				indegree[i]--;
				result[i] = Math.max(result[i], result[node] + timeArr[i]);
				if (indegree[i] == 0) {
					q.offer(i);
				}
			}

		}
		for (int i = 1; i <= N; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb);

	}
}
