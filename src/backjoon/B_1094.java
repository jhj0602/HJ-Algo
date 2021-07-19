package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1094 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String binary = Integer.toBinaryString(Integer.parseInt(br.readLine()));
		int count = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				count++;
			}
		}
		System.out.println(count);

	}

}
