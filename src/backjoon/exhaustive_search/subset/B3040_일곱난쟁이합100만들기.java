package backjoon.exhaustive_search.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3040_일곱난쟁이합100만들기 {
	static int[] nanjeng;
	static int[] temp;
	static int N = 9;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nanjeng = new int[9];
		temp = new int[7];
		for (int i = 0; i < 9; i++) {
			nanjeng[i] = Integer.parseInt(br.readLine());
		}
		combination(0, 0);
		System.out.println(sb);
	}

	private static void combination(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			int count = 0;
			for (int i = 0; i < 7; i++) {
				count++;
				sum += temp[i];
			}
			if (sum == 100 && count == 7) {
				for (int i = 0; i < 7; i++) {
					sb.append(temp[i] + "\n");
				}
				return;
			}

			return;
		}

		for (int i = start; i < N; i++) {
			temp[cnt] = nanjeng[i];
			combination(cnt + 1, i + 1);
		}

	}

}
