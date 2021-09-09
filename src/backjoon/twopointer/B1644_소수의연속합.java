package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1644_소수의연속합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
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
		int sum = 0;
		int count = 0;
		int left = 0, right = 0;
		while (right<=cnt) {
			if (sum >= n) {
				sum -= prime[left++];
			}else {
				sum += prime[right++];
			}
			if (sum == n) {
				count++;
			}
		}
		System.out.println(count);

	}

}
