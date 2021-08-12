package pc;

import java.util.Scanner;

public class SubSetTest {
	static int N, totalCnt, S;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		S = sc.nextInt();
		isSelected = new boolean[N];
		totalCnt = 0;
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset1(0);
		isSelected = new boolean[N];
		totalCnt = 0;
		generateSubset2(0);
		System.out.println("경우의 수 : " + totalCnt);

	}

	private static void generateSubset1(int cnt) {// 부분집합 구하기
		if (cnt == N) {// 하나의 부분집합이 완성 됐을 때 할일.
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i] ? input[i] : "X");
			}
			System.out.println();
			return;
		}

		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset1(cnt + 1);
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubset1(cnt + 1);
	}

	private static void generateSubset2(int cnt) {
		if (cnt == N) {
			// 부분집합 완성
			// 부분집합의 합을 계산
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i])
					sum += input[i];
			}
			// 부분집합의 합 == 목표합 체크
			if (sum == S) {
				totalCnt++;
				for (int i = 0; i < N; i++) {
					if (isSelected[i])
						System.out.print(input[i] + " ");
				}
				System.out.println();
			}

			return;
		}

		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset2(cnt + 1);
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubset2(cnt + 1);
	}

}
