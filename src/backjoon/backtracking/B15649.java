package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15649 {

	private static int arr[], visit[], n, m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];
		visit = new int[n + 1];
		backtracking(0);
		System.out.println(sb);

	}

	public static void backtracking(int y) {
		if (y == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= n; i++) {
				if (visit[i] == 1)
					continue;
				visit[i] = 1;
				arr[y] = i;
				backtracking(y + 1);
				visit[i] = 0;

			}
		}
	}

}
