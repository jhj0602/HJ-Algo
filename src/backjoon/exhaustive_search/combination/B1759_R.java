package backjoon.exhaustive_search.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_R {
	static int L, C;
	static char[] temp;
	static char [] str;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		str = br.readLine().replaceAll(" ", "").toCharArray();
		System.out.println(Arrays.toString(str));
		temp = new char[L];
		combination(0, 0);
		System.out.println(sb);

	}

	private static void combination(int cnt, int start) {
		if (cnt == L) {
			int moum = 0;
			int jaum = 0;
			for (int i = 0; i < temp.length; i++) {
				char c = temp[i];
				if (c == 'i' || c == 'e' || c == 'o' || c == 'u' || c == 'a') {
					moum++;
					continue;
				}
				jaum++;

			}
			if (moum > 0 && jaum > 1) {
				Arrays.sort(temp);
				String line  = new String(temp);
				sb.append(line+"\n");
				return;
			}

			System.out.println(Arrays.toString(temp));
			return;
		}
		for (int i = start; i < str.length; i++) {
			temp[cnt] = str[i];
			combination(cnt + 1, i + 1);
		}

	}

}
