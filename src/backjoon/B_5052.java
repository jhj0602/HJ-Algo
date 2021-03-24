package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class B_5052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] str = new String[n];
			for (int j = 0; j < n; j++) {
				str[j] = br.readLine();

			}
			if (solution(str)) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}

		}
		bw.flush();
		bw.close();
		br.close();
	}

	static boolean solution(String[] str) {
		Arrays.sort(str);

		boolean flag = false;

		for (int i = 0; i < str.length - 1; i++) {
			if (str[i + 1].startsWith(str[i])) {
				return false;
			}

			if (str[i].startsWith(str[i + 1])) {
				return false;
			}
		}
		return true;

	}

}
