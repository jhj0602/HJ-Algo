package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW1208 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] strArr = br.readLine().split(" ");
			Queue<String> firstQ = new LinkedList<>();
			Queue<String> secondQ = new LinkedList<>();
			int halfLen = 0;
			if (N % 2 == 0) {
				halfLen = strArr.length / 2;

			} else {
				halfLen = strArr.length / 2 + 1;
			}

			for (int i = 0; i < halfLen; i++) {
				firstQ.offer(strArr[i]);
			}
			for (int i = halfLen; i < strArr.length; i++) {
				secondQ.offer(strArr[i]);
			}
			sb.append("#"+test_case+" ");
			while (true) {
				if (!firstQ.isEmpty()||!secondQ.isEmpty()) {
					sb.append(firstQ.poll() + " ");
					sb.append(secondQ.poll() + " ");
				}
				
				if (firstQ.isEmpty() && secondQ.isEmpty()) {
					break;
				}

			}
			sb.append("\n");

		}
		br.close();
		System.out.println(sb);
	}

}
