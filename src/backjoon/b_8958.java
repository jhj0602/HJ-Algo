package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_8958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		String[] lineArr = new String[num];
		for (int i = 0; i < num; i++) {
			lineArr[i] = br.readLine();
			int finalCnt = 0;

			int cnt1 = 0;
			for (int j = 0; j < lineArr[i].length(); j++) {
				if (lineArr[i].charAt(j) == 'X') {
					cnt1 = 0;
				} else {
					cnt1++;
					finalCnt += cnt1;

				}

			}
			sb.append(finalCnt + "\n");
		}
		System.out.println(sb);

	}

}
