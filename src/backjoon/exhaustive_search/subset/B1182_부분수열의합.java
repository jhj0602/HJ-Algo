package backjoon.exhaustive_search.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;import java.util.Arrays;
import java.util.StringTokenizer;

public class B1182_부분수열의합 {
	static int N;
	static int S;
	static int count=0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		generateSubset(0, 0);
		System.out.println(count);
	}

	private static void generateSubset(int cnt, int sum) {
		if (cnt == N) {// 하나의 부분집합이 완성 됐을 때 할일.
			if (sum == 0) {
				count++;
			}
			return;
		}
		
		generateSubset(cnt + 1, sum + arr[cnt]);
		
		generateSubset(cnt + 1, sum);
	}
}
