package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_2357 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int j = x - 1; j < y; j++) {
				pq.add(list.get(j));
			}
			int cnt = 0;
			int min = 0;
			int max = 0;
			min = pq.peek();
			while (true) {
				cnt++;
				if (cnt == y - x + 1) {
					max = pq.poll();
					break;
				} else {
					pq.poll();
				}
			}
			sb.append(min+" "+max+"\n");

		}
		System.out.println(sb);

	}

}
