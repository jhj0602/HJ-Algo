package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class B_5430 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();

			solution(p, n, arr);

		}
		System.out.println(sb);

	}

	static void solution(String p, int n, String arr) {
		Deque<String> list = new LinkedList<>();
		Deque<String> listTemp = new LinkedList<>();
		arr = arr.substring(1, arr.length() - 1);
		String bucket[] = arr.split(",");

		if (bucket.length > 1) {
			for (int i = 0; i < bucket.length; i++) {

				list.offer(bucket[i]);
			}
		}

		listTemp = list;
		int reverse = 0;
		boolean flag = false;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == 'R') {
				reverse++;
			} else if (p.charAt(i) == 'D' && listTemp.isEmpty()) {
				System.out.println("error");
				flag = true;
				break;
			} else if (p.charAt(i) == 'D' && !listTemp.isEmpty()) {
				if (reverse % 2 == 1) {
					listTemp.pollLast();
				} else {
					listTemp.pollFirst();
				}
			}

		}
		if (!flag) {
			String result = "";
			if (reverse % 2 == 1) {
				while (!listTemp.isEmpty()) {

					result += listTemp.peekLast();
					listTemp.pollLast();

					if (listTemp.size() == 0) {
						break;
					} else {
						result += ",";
					}

				}

			} else {
				while (!listTemp.isEmpty()) {
					result += listTemp.peekFirst();
					listTemp.pollFirst();
					if (listTemp.size() == 0) {
						break;
					} else {
						result += ",";
					}

				}
			}
System.out.println("[" + result + "]" + "\n");
		

		}
	}

}
