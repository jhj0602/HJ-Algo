package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16926_배열돌리기 {
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 };// 하 우 상 좌
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		int group = Math.min(N, M) / 2;

		for (int r = 0; r < R; r++) {

			for (int i = 1; i <= group; i++) {
				// 네모들의 왼쪽 맨위의 좌표는 1,1 || 2,2 || 3,3 || ...
				int x = i;
				int y = i;
				int temp = arr[x][y]; // 첫번째 값을 담아놓고 연산 후에 넣어준다.
				int index = 0;
				while (index < 4) {
					int nx = x + dx[index];
					int ny = y + dy[index];

					if (nx < i || ny < i || nx > N - i + 1 || ny > M - i + 1) {
						index++;
					} else {
//						System.out.println("nx "+nx+"  ny "+ny);
//						System.out.println("이동 전"+arr[x][y]+"  x "+x+"  y "+y);
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
//						System.out.println("이동 후"+arr[x][y]+"  x "+x+"  y "+y);
					}
				}
				arr[i + 1][i] = temp;
			} 

		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sb.append(arr[i][j] + " ");
				
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
