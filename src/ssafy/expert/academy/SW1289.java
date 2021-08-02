package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			char[] temp = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				temp[i] = '0';
			}
			int cnt = 0;

			for (int i = 0; i < str.length(); i++) {
				if ((int) str.charAt(i) != temp[i]) {
					cnt++;
					for (int j = i; j < str.length(); j++) {
						temp[j] = str.charAt(i);
					}
				}
			}
			sb.append("#" + test_case + " " + cnt+"\n");

		}
		System.out.println(sb);
	}
}
