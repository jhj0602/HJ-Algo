package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = "";

		while ((str = br.readLine()) != "0") {
			int len = str.length();
			len = len % 2 == 0 ? len / 2 : len / 2 + 1;
			System.out.println(len);

		
		}

	}

}
