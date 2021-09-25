package backjoon.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1766 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[] indegree = new int[V+1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V + 1; i++)
			list.add(new ArrayList<Integer>());
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken()) ;

			list.get(from).add(to);
			indegree[to]++;
		}
		
		
	  
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 1; i <= V; i++) {
			if (indegree[i] == 0) {
				pq.offer(i);
			}
		}
		while (!pq.isEmpty()) {
			int node = pq.poll();
			sb.append(node).append(" ");
			for(int linked : list.get(node)) {
                indegree[linked]--;
                if(indegree[linked] == 0)
                    pq.offer(linked);
            }
		}
		sb.append("\n");
		System.out.println(sb);

	}


}
