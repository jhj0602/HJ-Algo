package backjoon.gridy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		list.add(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
			pq.offer(list.get(i)-list.get(i-1));
		}
		int sum=0;
		for (int i = 0; i < n-k; i++) {
			sum+=pq.poll();
		}
		
		System.out.println(sum);
	}

}
