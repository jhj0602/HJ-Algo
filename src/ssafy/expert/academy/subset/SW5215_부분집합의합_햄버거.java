package ssafy.expert.academy.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW5215_부분집합의합_햄버거 {
	static int[] kcalorie;
	static int[] score;
	static int L;
	static int N;
	static int max;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 재료
			L = Integer.parseInt(st.nextToken());// 칼로리제한
			score = new int[N];
			kcalorie = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				kcalorie[i] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			dfs(0, 0, 0);
			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cnt, int sco, int kcal) {
		if (kcal > L) {
			return;
		}
		if (cnt == N) {
			max = Math.max(max, sco);
			return;
		}
		// 현재원소를 부분집합에 넣기
		dfs(cnt + 1, sco + score[cnt], kcal + kcalorie[cnt]);
		// 현재 원소를 부분집합에 않넣기
		dfs(cnt + 1, sco, kcal);
	}

}
