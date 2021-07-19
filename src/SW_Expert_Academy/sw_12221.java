package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sw_12221 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int x =sc.nextInt();
			int y =sc.nextInt();
			if (x > 9 || y > 9) {
				sb.append("#"+test_case+"-1 " + "\n");
			} else {
				sb.append("#"+test_case+" "+x * y + "\n");
			}

		}
		System.out.println(sb);
	}
}
