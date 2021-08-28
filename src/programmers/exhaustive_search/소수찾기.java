package programmers.exhaustive_search;

import java.util.HashSet;

public class 소수찾기 {

	static int N;
	static String[] str;
	static String[] arr;
	static int count = 0;
	static HashSet<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) {
		solution("011");
		System.out.println(solution("17"));
	}

	public static int solution(String numbers) {
		int answer = 0;
		N = numbers.length();
		str = numbers.split("");
		arr = new String[N];
		permutation(0);
		return answer = set.size();
	}

	private static void permutation(int cnt) {
		if (cnt == N) {
			String sum = "";
			for (String s : arr) {
				sum += s;
			}
			boolean isPrime = false;
			int value = Integer.parseInt(sum);

			for (int i = 2; i < value; i++) {
				if (value % i == 0) {
					isPrime = true;
					break;
				}
			}

			if (!isPrime) {
				set.add(value);
				count++;
			}
			System.out.println(sum);

			return;
		}
		for (int i = 0; i < N; i++) {
			arr[cnt] = str[i];
			permutation(cnt + 1);

		}
	}
}
