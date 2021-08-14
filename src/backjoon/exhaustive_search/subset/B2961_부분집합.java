package backjoon.exhaustive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_부분집합 {
	static class Dot {
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static Dot[] arr;
	static boolean[] isSelected;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new Dot[N];
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Dot(x, y);
		}
		generateSubset(0, 1, 0);//인덱스 , 신맛곱,쓴맛더한거
		System.out.println(min);

	}

	private static void generateSubset(int cnt, int sin, int ssn) {
		if (cnt == N) {// 하나의 부분집합이 완성 됐을 때 할일.
			if (sin != 1 && ssn != 0) {
				min = Math.min(Math.abs(sin - ssn), min);
			}
			return;
		}
		generateSubset(cnt + 1, sin * arr[cnt].x, ssn + arr[cnt].y);
		generateSubset(cnt + 1, sin, ssn);
	}

}
