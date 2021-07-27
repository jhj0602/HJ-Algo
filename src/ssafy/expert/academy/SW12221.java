package ssafy.expert.academy;

import java.util.Scanner;

class SW12221 {
	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int x = sc.nextInt();
			int y = sc.nextInt();
			if (x > 9 || y > 9) {
				sb.append("#" + test_case + " -1 " + "\n");
			} else {
				sb.append("#" + test_case + " " + x * y + "\n");
			}

		}
		System.out.println(sb);
	}
}