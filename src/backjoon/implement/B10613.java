package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[1001][1001];
		int[] count = new int[N];
		for (int i = 1; i < N + 1; i++) {// test case
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			for (int j = x; j < height + x; j++) {
				for (int k = y; k < width + y; k++) {
					arr[j][k] = i;
				}
			}
		}
		for (int i = 0; i < count.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr.length; k++) {
					if (arr[j][k] == i + 1) {
						sum++;
					}
				}
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);

	}

}
