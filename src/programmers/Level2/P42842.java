package programmers.Level2;

import java.util.Arrays;

public class P42842 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));

	}

	public static int[] solution(int brown, int yellow) {
		int w = 0;// 가로
		int h = 0;// 세로
		boolean flag = false;
		while (flag != true) {
			w++;
			for (h = 1; h <= w; h++) {
				if (yellow == (w - 2) * (h - 2) && h * w == brown + yellow) {
					flag = true;
					break;
				}
			}
		}
		int[] answer = { w, h };
		return answer;
	}
}
