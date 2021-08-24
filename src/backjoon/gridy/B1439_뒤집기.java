package backjoon.gridy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1439_뒤집기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] S = br.readLine().split("");
		int zeroCnt = 0;
		int oneCnt = 0;
		for (int i = 0; i < S.length; i++) {
			if (S[i] == "1") {
				oneCnt++;
			} else {
				zeroCnt++;
			}
		}
		if (zeroCnt == S.length || oneCnt == S.length) {
			sb.append(0);
		} else {
			if (zeroCnt >= oneCnt) {
				
			} else {

			}
		}
	}

}
