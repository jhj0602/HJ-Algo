package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW3289_서로소집합 {

	static int N, M;// 원소갯수
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			make();
			sb.append("#"+test_case+" ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int oper = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (oper == 1) {
					int x = find(a);
					int y = find(b);
					if (x == y) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				} else {
					union(a, b);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void make() {
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 1; i <= N; i++) {
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
}
