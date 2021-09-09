package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2003_TwoPointer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int min = 100001;
		int left = 0, right = 0;
		while (true) {
			if (sum >= m) {
				min = Math.min(min, right - left);
				sum -= arr[left++];
			} else if (right == n) {
				break;
			} else {
				sum += arr[right++];
			}

		}
		System.out.println(min == 100001 ? 0 : min);
	}

}
