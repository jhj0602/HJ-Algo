package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17471 {
	static int n;
	static boolean[] isSelect;
	static ArrayList<Integer> list;
	static int min = Integer.MAX_VALUE;

	static ArrayList<Integer>[] adj;

	static int population[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		population = new int[n + 1];
		
		adj = new ArrayList[n + 1];
		String str[] = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(str[i - 1]);
			adj[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		isSelect = new boolean[n + 1];
		subset(1);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	private static void subset(int count) { // count: 현재까지 고려한 원소 수
		if (count == n + 1) {
			if (connected()) {
				int peopleA = 0;
				int peopleB = 0;
				for (int i = 1; i < isSelect.length; i++) {
					if (isSelect[i]) {
						peopleA += population[i];
					} else {
						peopleB += population[i];
					}
				}
				min =  Math.min(min, Math.abs(peopleA-peopleB));
			}
			return;
		}
		isSelect[count] = true;
		subset(count + 1);
		isSelect[count] = false;
		subset(count + 1);
	}
	private static boolean connected() {
		boolean[] visit = new boolean[n + 1];

		int areaA = -1;
		// A선거구 구역에 포함된 한 구역을 찾기
		for (int i = 1; i <= n; i++) {
			if (isSelect[i]) {
				areaA = i;
				break;
			}
		}
		int areaB = -1;
		// B선거구 구역에 포함된 한 구역을 찾기
		for (int i = 1; i <= n; i++) {
			if (!isSelect[i]) {
				areaB = i;
				break;
			}
		}

		if (areaA == -1 || areaB == -1)
			return false;

		Queue<Integer> q = new LinkedList<>();
		q.offer(areaA);
		visit[areaA] = true;
		// A구역 BFS
		while (!q.isEmpty()) {
			int c = q.poll();
			for (int i = 0; i < adj[c].size(); i++) {
				if (visit[adj[c].get(i)])
					continue;
				if (!isSelect[adj[c].get(i)])
					continue;
				visit[adj[c].get(i)] = true;
				q.offer(adj[c].get(i));
			}
		}
		// B구역 BFS
		q.offer(areaB);
		visit[areaB] = true;
		while (!q.isEmpty()) {
			int c = q.poll();
			for (int i = 0; i < adj[c].size(); i++) {
				if (visit[adj[c].get(i)])
					continue;
				if (isSelect[adj[c].get(i)])
					continue;
				visit[adj[c].get(i)] = true;
				q.offer(adj[c].get(i));
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!visit[i])
				return false;
		}
		return true;

	}

}
