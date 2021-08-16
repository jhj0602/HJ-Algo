package backjoon.exhaustive_search.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10819_차이를최대로 {
	static int N;
	static int[] numbers, temp;
	static boolean[] isSelected;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		temp = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		permutation(0);
		System.out.println(max);
	}

	private static void permutation(int cnt) {
		if (cnt == N) {
			maxValueSearch();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			temp[cnt] = numbers[i];
			isSelected[i] = true;

			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static void maxValueSearch() {
		int sum = 0;
		for (int i = 1; i < N; i++) {
			sum += Math.abs(temp[i - 1] - temp[i]);
		}
		max = Math.max(max, sum);
	}
}
