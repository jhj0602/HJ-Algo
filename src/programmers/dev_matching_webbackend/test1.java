package programmers.dev_matching_webbackend;

import java.util.Arrays;
import java.util.HashMap;

public class test1 {

	public static void main(String[] args) {
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
		int[] lottos2 = { 0, 0, 0, 0, 0, 0 };
		int[] win_nums2 = { 38, 19, 20, 40, 15, 25 };
		System.out.println(Arrays.toString(solution(lottos2, win_nums2)));

	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int zero = 0;
		for (int i : lottos) {
			if (i == 0) {
				zero++;
			} else {
				map.put(i, 1);
			}
		}
		int cnt = 0;
		for (int i : win_nums) {
			if (map.containsKey(i)) {
				cnt++;
				continue;
			}

		}
		answer[0] = zero + cnt;
		answer[1] = cnt;
		int[] result = new int[2];
		for (int i = 0; i < result.length; i++) {
			if (answer[i] == 6) {
				result[i] = 1;
			} else if (answer[i] == 5) {
				result[i] = 2;
			} else if (answer[i] == 4) {
				result[i] = 3;
			} else if (answer[i] == 3) {
				result[i] = 4;
			} else if (answer[i] == 2) {
				result[i] = 5;
			} else {
				result[i] = 6;
			}
		}

		return result;
	}
}
