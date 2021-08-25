package pc;

import java.util.Arrays;

public class PermutationTest_비트마스킹 {//비트마스킹 순열
	static int N = 3;
	static int R = 2;
	static int[] input={ 1, 4, 7 };
	static int[] numbers ;

	public static void main(String[] args) {
		numbers = new int[R];
		permutation(0, 0);

	}

	private static void permutation(int cnt, int flag) {
		if (cnt == R) {

			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)// i번 만큼 시프팅 하자
				continue;// 사용중인 수면 다음 수로

			numbers[cnt] = input[i];
			permutation(cnt + 1, flag | 1 << i);


		}

	}

}
