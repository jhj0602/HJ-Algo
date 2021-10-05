package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15961_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] dish = new int[n];
		int[] eaten = new int[d + 1];
		for (int i = 0; i < n; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		int total = 0;
		int max = 0;
		for (int i = 0; i < k; i++) {
			if (eaten[dish[i]] == 0) {
				total++;

			}
			eaten[dish[i]]++;
		}
		System.out.println("total: "+total+" "+Arrays.toString(eaten));
		max = total;
		for (int i = 0; i < n; i++) {
			if (max <= total) {
				if (eaten[c] == 0) {
					max = total + 1;
				} else {
					max = total;
				}
			}
			eaten[dish[i]]--;
			if (eaten[dish[i]] == 0) {
				total--;
			}
			if (eaten[dish[(i + k) % n]] == 0) {
				total++;
			}
			eaten[dish[(i + k) % n]]++;
			System.out.println(Arrays.toString(eaten));
		}
		System.out.println(max);

	}

}
