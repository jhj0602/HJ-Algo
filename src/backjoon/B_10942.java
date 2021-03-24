package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_10942 {
	static int[] arr;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {//병신같은 범위 때문에 3시간 ㅅㅂ
			arr[i] = Integer.parseInt(st.nextToken());

		}
		int M = Integer.parseInt(br.readLine());
		int[][] SE = new int[M][2];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			SE[i][0] = Integer.parseInt(st.nextToken());
			SE[i][1] = Integer.parseInt(st.nextToken());

			if (solution(SE[i][0], SE[i][1], i + 1)) {
				bw.write(1 + "\n");
			} else {
				bw.write(0 + "\n");
			}

		}
		bw.flush();
		bw.close();
		br.close();

	}

	static boolean solution(int x, int y, int p) {
		// 짝수 홀수 비교
		int compareNum = y - x + 1;
		boolean result = true;

		if (compareNum % 2 != 0) {

			int cnt = 0;
			// 홀수개
			for (int i = 0; i < compareNum - 1; i++) {
				if (cnt == compareNum / 2 + 1) {
					result = true;
					break;
				}
				if (arr[x] == arr[y]) {

					cnt++;
					x++;
					y--;
				} else {
					result = false;
					break;
				}

			}
		} else {
			// 짝수개
			int cnt = 0;

			for (int i = 0; i < compareNum + 1; i++) {
				if (cnt == compareNum / 2) {
					result = true;
					break;
				}
				if (arr[x] == arr[y]) {
					cnt++;
					x++;
					y--;
				} else {
					result = false;
					break;
				}

			}

		}
		return result;

	}

}
