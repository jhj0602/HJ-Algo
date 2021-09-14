package backjoon.exhaustive_search.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1038 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean [] arr = new boolean[1000001];
		int count = 0;
		for (int i = 0; i <= arr.length; i++) {
			if (i % 10 < 10) {
				count++;
			} else {
				
			}

			if (count - 1 == n) {
				System.out.println(i);
				break;
			}
		}
	}

}
