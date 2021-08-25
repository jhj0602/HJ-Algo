package ssafy.onlin_learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);// 오른차순의 결과
		}

	}

	static int V, E;
	static Edge[] edgeList;
	static int[] parents;

	private static void make() {
		parents = new int[V];
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;// 자신이 대표자
		return parents[a] = find(parents[a]);// 자신이 속한 집합의 대표자를 자신의 부모로
	}

	// 두 원소를 하나의 집합으로 합치기
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		// 간선 리스트 작성
		edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(edgeList);
		make();// 모든 정점을 각각으로 집합으로 만들고 출발
		// 간선 하나씩 시도하며 트리 만들어감
		int result = 0, cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				result += edge.weight;
				if (++cnt == V - 1)
					break;
			}
		}
		System.out.println(result);
	}

}
