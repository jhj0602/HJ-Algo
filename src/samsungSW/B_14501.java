package samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14501 {
	static int N;
	static int count = 0;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

		}
		benifitCalculate(0, 0);
		System.out.println(count);
	}

	static void benifitCalculate(int x, int y) {

		if (x >= N) {
			count = Math.max(count, y);
			return;
		}
		if (x + arr[x][0] <= N) {

			benifitCalculate(x + arr[x][0], y + arr[x][1]);
		} else {
			benifitCalculate(x + arr[x][0], y);
		}
		System.out.println(arr[x][0]+ "count :"+count);
		benifitCalculate(x + 1, y);
	}

}
