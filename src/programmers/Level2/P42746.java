// 정렬/가장큰 수 Level2
package programmers.Level2;

import java.util.Arrays;

public class P42746 {

	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String answer = "";
		String[] str = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
		if (str[0].equals("0")) {
			return "0";
		}
		for (String string : str) {
			answer += string;
		}

		return answer;
	}
}
