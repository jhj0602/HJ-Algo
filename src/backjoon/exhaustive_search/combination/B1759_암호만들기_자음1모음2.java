package backjoon.exhaustive_search.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_자음1모음2 {
	static char[] arr;
	static char[] temp;
	static boolean[] isSelected;
	static int L;
	static int C;
	static int moum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());// 뽑는 수
		C = Integer.parseInt(st.nextToken());// 갯수
		arr = new char[C];
		 st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		temp = new char[L];
		Arrays.sort(arr);

		combination(0, 0);
		System.out.println(sb);

	}

	private static void combination(int cnt, int start) {
		if (cnt == L) {
			int moum = 0;// 모음 카운트
			for (int i = 0; i < temp.length; i++) {
				char c = temp[i];
				if (c =='a' || c =='e' || c =='i'|| c =='o' ||c =='u') {
					moum++;
				}
			}
			if (moum != 0 && temp.length - moum >= 2) {
				for (int i = 0; i < temp.length; i++) {
					sb.append(temp[i]);
				}
				sb.append("\n");
				return;
			} else {
				return;
			}
		}
		for (int i = start; i < C; i++) {
			temp[cnt] = arr[i];
			combination(cnt + 1, i + 1);
		}
	}
}
