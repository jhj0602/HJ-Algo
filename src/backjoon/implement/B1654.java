package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		long max = arr[k - 1];
		long min = 1;
		long mid = 0;
		while (max >= min) {
			mid = (max + min) / 2;
			long cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				cnt += arr[i] / mid;
			}
			if (cnt >= n) {
				min = mid + 1;
			} else if (cnt < n) {
				max = mid - 1;
			}
		}
		System.out.println(max);

	}
}
