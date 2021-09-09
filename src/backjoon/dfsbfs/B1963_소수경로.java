package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import backjoon.dfsbfs.B2665_미로탐색.dot;

public class B1963_소수경로 {
	static int[] primeArr = { 1, 2, 3, 5, 7 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(isPrime(1233));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String start = st.nextToken();
			String end = st.nextToken();
			if (isPrime(Integer.parseInt(start)) && isPrime(Integer.parseInt(end)) && Integer.parseInt(start) > 999
					&& Integer.parseInt(end) > 999) {
//				bfs(start,end);
			} else {
				System.out.println("impossible");
			}

		}

	}

//	static void bfs(String start, String end) {
//		Queue<String> q = new LinkedList<>();
//		q.offer();
//		while (!q.isEmpty()) {
//			dot dot = q.poll();
//			for (int i = 0; i < 5; i++) {
//
//			}
//		}
//	}

	public static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
