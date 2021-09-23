package ssafy.expert.academy.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW3307 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int[] lis = new int[n];
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			int max = 0;
			for (int i = 0; i < n; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
					}
				}
				max = Math.max(lis[i], max);
			}
			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.println(sb);
	}

}
