package kakao_makers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution3 {

	static ArrayList<Integer>[] adj;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] passenger = { 1, 1, 1, 1, 1, 1 };
		int[][] train = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 5 }, { 3, 6 } };

		System.out.println(solution(6, passenger, train));
	}

	public static int[] solution(int n, int[] passenger, int[][] train) {
		adj = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		int[] temp = new int[n + 1];
		temp[1] = passenger[0];
		int[] answer = { 1, temp[1] };

		for (int i = 0; i < train.length; i++) {
			adj[train[i][0]].add(train[i][1]);
		}
		for (int i = 1; i < n + 1; i++) {
			listSort(i);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		while (!queue.isEmpty()) {

			int vertex = queue.poll();

			for(int i=0;i< adj[vertex].size();i++) {
				if (temp[adj[vertex].get(i)] == 0) {

					temp[adj[vertex].get(i)] = temp[vertex] + passenger[adj[vertex].get(i) - 1];
					queue.add(adj[vertex].get(i));

					if (temp[adj[vertex].get(i)] >= answer[1]) {
						if (answer[0] < adj[vertex].get(i))
							answer[0] = adj[vertex].get(i);
						answer[1] = temp[adj[vertex].get(i)];
					}
				}
			}
		
		}

		return answer;
	}

	public static void listSort(int i) {
		Collections.sort(adj[i]);
	}
}