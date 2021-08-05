package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2805 {
	static int[][] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int i = N / 2; i >= 0; i--) {// 위
				String s = br.readLine();
				System.out.println(s);
				System.out.println();
				for (int j = i; j < N - i; j++) {
					System.out.print(s.charAt(j) - '0'+"count j: "+j+" i:"+i+"  ");
					sum += s.charAt(j) - '0';
				}
				System.out.println();
			}
			for (int i = 1; i <= N / 2; i++) {// 아래
				String s = br.readLine();
				System.out.println(s);
				System.out.println();
				for (int j = i; j < N - i; j++) {
					System.out.print(s.charAt(j) - '0'+"count j: "+j+" i:"+i+"  ");
					sum += s.charAt(j) - '0';
				}
			}
			sb.append("#" + t + " " + sum + "\n");
		}
		br.close();
		System.out.println(sb);
	}
}
