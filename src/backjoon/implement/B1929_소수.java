package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1929_소수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			arr[i] = i;
		}
		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i + i; j <= n; j += i) {
				arr[j] = 0;
			}
		}
		int[] prime = new int[n + 1];
		int cnt = 0;
		for (int i = 2; i <= n; i++) {
			if (arr[i] != 0)
				prime[cnt++] = i;
		}
		for (int i : prime) {
			if (i == 0) {
				break;
			}
			if (i >= m) {
				sb.append(i + "\n");
			}

		}
		System.out.println(sb);
	}

}
