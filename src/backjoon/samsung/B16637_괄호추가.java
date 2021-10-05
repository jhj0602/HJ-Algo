package backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B16637_괄호추가 {
	static int r;
	static int[] operIdx;
	static int[] temp;
	static boolean[] isSelected;
	static String str;
	static int max = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		str = br.readLine();
		int cnt = 0;
		r = n / 2;
		System.out.println(n / 2);
		operIdx = new int[r];
		temp = new int[r];
		for (int i = 0; i < n; i++) {
			if (i % 2 == 1) {
				operIdx[cnt] = i;
				cnt++;
			}
		}
		isSelected = new boolean[r];
		permutaion(0);

	}

	private static void permutaion(int cnt) {
		if (cnt == r) {
			System.out.println(Arrays.toString(temp));
			calc(temp);
			return;
		}
		for (int i = 0; i < r; i++) {
			if (isSelected[i])
				continue;
			temp[cnt] = operIdx[i];
			isSelected[i] = true;
			permutaion(cnt + 1);
			isSelected[i] = false;

		}
	}

	private static void calc(int[] temp) {
		for (int i = 0; i < temp.length; i++) {
			char c = str.charAt(temp[i]);
			if (c == '*') {
				
			} else if (c == '+') {

			} else if (c == '-') {

			}
		}

	}

}
