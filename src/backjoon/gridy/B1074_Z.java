package backjoon.gridy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074_Z {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		search((int) Math.pow(2, n), r, c);
		System.out.println(count);
	}

	private static void search(int n, int r, int c) {
		if (n == 1) {
			return;
		}
		if (r < n / 2 && c < n / 2) {// 1 area
			System.out.println(count);
			search(n / 2, r, c);
		} else if (r < n / 2 && c >= n / 2) {//2 area
			count += n * n / 4;
			System.out.println(count);
			search(n / 2, r, c - n / 2);
		} else if (r >= n / 2 && c < n / 2) {//3 area
			count += (n * n / 4) * 2;
			System.out.println(count);
			search(n / 2, r - n / 2, c);
		} else {//4 area
			count += (n * n / 4) * 3;
			System.out.println(count);
			search(n / 2, r - n / 2, c - n / 2);
		}
	}
}
