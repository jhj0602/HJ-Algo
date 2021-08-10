package backjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(i + 1);
		}
		int index = M - 1;
		int i = 0;
		sb.append("<");
		while (!list.isEmpty()) {
			i += index;
			if (i >= list.size()) {
				i %= list.size();
			}
			sb.append(list.remove(i)).append(", ");

		}
		System.out.println(sb.toString().substring(0, sb.length() - 2) + ">");

	}

}
