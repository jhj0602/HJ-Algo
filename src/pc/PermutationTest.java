package pc;

import java.util.Arrays;

public class PermutationTest {
	static int N=3;
	static int R = 3;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) {
		numbers = new int[R];
		isSelected = new boolean[N + 1];
		permutation(0);

	}

	private static void permutation(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (isSelected[i])
				continue;// 사용중인 수면 다음 수로

			numbers[cnt] = i;
			isSelected[i] = true;

			permutation(cnt + 1);
			isSelected[i] = false;

		}
	}

}
