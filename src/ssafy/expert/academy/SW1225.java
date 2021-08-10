package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1225 {
	static Queue<Integer> list = new LinkedList<Integer>();
	static int[] pattern = { 1, 2, 3, 4, 5 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			solution();
			sb.append("#" + test_case + " ");
			for (int i = 0; i < 8; i++) {
				sb.append(list.poll() + " ");
			}
			list.clear();
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();

	}

	private static void solution() {//반복문 라벨 붙이기 top:while    break 문 뒤에 top
		int n = 0;
		while (true) {

			int temp = list.poll() - pattern[n];
			if (temp <= 0) {
				temp = 0;
				list.offer(temp);
				break;
			}
			list.offer(temp);
			n++;
			n = n % 5;
		}

	}

}
