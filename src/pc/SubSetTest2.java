package pc;

import java.util.Scanner;

public class SubSetTest2 {
	static int N, S;
	static int totalCnt, totalCnt2 = 0;
	static int callCnt, callCnt2 = 0;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		S = sc.nextInt();
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		generateSubset(0, 0);
		System.out.println("경우의 수 : " + totalCnt);
		System.out.println("호출횟 수 : " + callCnt);
		isSelected = new boolean[N];
		totalCnt2 = 0;
		generateSubset2(0, 0);
		System.out.println("경우의 수 : " + totalCnt2);
		System.out.println("호출횟 수 : " + callCnt2);
	}

	private static void generateSubset(int cnt, int sum) {
		callCnt++;
		if (cnt == N) {
			// 부분집합 완성
			// 부분집합의 합을 계산
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
		generateSubset(cnt + 1, sum + input[cnt]);
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubset(cnt + 1, sum);
	}

	private static void generateSubset2(int cnt, int sum) {//가지 치기
		callCnt2++;
		if (sum == S) {
			totalCnt2++;
			for (int i = 0; i < N; i++) {
				if (isSelected[i])
					System.out.print(input[i] + " ");
			}
			System.out.println();
			return;
		}
		if (sum > S || cnt == N) {
			return;
		}

		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset2(cnt + 1, sum + input[cnt]);
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubset2(cnt + 1, sum);
	}
}
