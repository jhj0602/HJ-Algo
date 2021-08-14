package backjoon.exhaustive_search.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B6603_로또 {
	static int[] temp;
	static int N;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);//뽑는수
			if (N == 0)
				break;
			arr = new int[N];
			temp = new int[6];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(line[i + 1]);
			}
			comb(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < temp.length; i++) {
				sb.append(temp[i]+" ");
			}
			sb.append("\n");
			return;

		}
		for (int i = start; i < N; i++) {
			temp[cnt] = arr[i];
			comb(cnt+1,i+1);
		}
	}

}
