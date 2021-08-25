package pc;

public class NextCombination {

	public static void main(String[] args) {
		int[] input = { 7, 1, 4, 2, 3 };
		int N = input.length;
		int R = 4;
		int[] p = new int[N];

		// 뒤쪽부터 R개만큼 1채우기
		int cnt = 0;
		while (++cnt <= R) {
			p[N - cnt] = 1;
		}
		do {
			for (int i = 0; i < N; i++) {
				if (p[i] == 1) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
		} while (np(input));
	}

	private static boolean np(int[] numbers) {
		int N = numbers.length;
		// step1. 꼭대기를 찾는다. 꼭대기를 통해 교환 위치(i-1)를 찾는다
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) {
			--i;
		}
		if (i == 0)
			return false;
		// step2
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;
		// step 3. i-1위치값과 j의 위치값 교환
		swap(numbers, i - 1, j);
		// step4. 꼭대기부터 맨뒤 까지 내림차순형태의 순열을 오름차순으로 처리
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}
		return true;

	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}