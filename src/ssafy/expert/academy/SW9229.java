package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW9229 {
	static int N, M;
	static int[] arr;
	static int[] numbers;
	static int result;
	static int sum;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N];
			numbers = new int[2];
			result = 0;
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			combination(0, 0);
			if (result != 0) {
				sb.append("#" + test_case + " " + result + "\n");
			} else {
				sb.append("#" + test_case + " " + -1 + "\n");
			}

		}
		System.out.println(sb);
		br.close();

	}

	private static void combination(int cnt, int start) {
		if (cnt == 2) {
			int tempSum = 0;
			for (int i = 0; i < 2; i++) {
				tempSum += numbers[i];
			}
			if (tempSum <= M) {
				if (tempSum >= sum) {
					sum = tempSum;
				}
				result = Math.max(sum, tempSum);
			}

			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = arr[i];
			combination(cnt + 1, i + 1);
		}
	}

}
