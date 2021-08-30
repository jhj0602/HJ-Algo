package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1913 {
	static int[] dx = { 1, 0, -1, 0 };// 하 우 상 좌
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static int firstNum;
static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		 N = Integer.parseInt(br.readLine());
		firstNum = N * N;
		int num = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		arr[1][1] =firstNum;
		saveNum(1, 1, N - 1, 0);
		
	}

	private static void saveNum(int x, int y, int n, int pattern) {
		if (pattern == 4) {
			pattern = 0;
			n=n-1;

		}
		for (int i = 0; i < n; i++) {
			x = x + dx[pattern];
			y = y + dy[pattern];
			arr[x][y] = --firstNum;
			if(arr[x][y]==1) {
				return;
			}
			System.out.println(x+" "+y);
			
		
		}
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < N+1; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		saveNum(x,y,n,pattern+1);

	}

}
