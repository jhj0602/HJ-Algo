package backjoon.implement.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RB17609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			int result = 0;
			int left = 0;
			int right = str.length() - 1;
			while (left <= right) {
				if (str.charAt(left) == str.charAt(right)) {// 회문일때
					left++;
					right--;
				} else {
					int l = left;
					int r = right;
					l++;
					while (l <= r) {
						if (str.charAt(l) == str.charAt(r)) {
							l++;
							r--;
						} else {
							result++;
							break;
						}
					}
					l = left;
					r = right;
					r--;
					while (l <= r) {
						if (str.charAt(l) == str.charAt(r)) {
							l++;
							r--;
						} else {
							result++;
							break;
						}

					}
					break;
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);

	}
}
