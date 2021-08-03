package pc;

import java.util.Arrays;

public class CombinationTest {
	static int N = 3;
	static int R = 2;
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) {
		input = new int[] { 1, 4, 7 };
		numbers = new int[R];
		isSelected = new boolean[N];
		combination(0, 0);

	}

	private static void combination(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수들이 들어있는 배열 모든 원소에 대해 시도
		for (int i = start; i < N; i++) {// 인덱스로 체크
			numbers[cnt] = input[i];
			// 다음 자리 순열 뽑으러감
			combination(cnt + 1, i + 1);

		}
	}

}
