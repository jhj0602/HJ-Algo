package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = " " + br.readLine();
		char[] arr = s.toCharArray();
		int idx = 0;
		int cnt = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 'N') {
				continue;
			}
			idx = i;
			for (int j = idx; j < arr.length; j += idx) {
				if (arr[j] == 'Y') {
					arr[j] = 'N';
				}else {
					arr[j]='Y';
				}
			}
			cnt++;
		}
		System.out.println(cnt);

	}

}
