package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_1786 {
	static String T;
	static String P;
	static int cnt = 0;
	static List<Integer> lineIndex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = br.readLine();
		P = br.readLine();
		lineIndex = new ArrayList<>();
		KMP(T, P);
		sb.append(cnt + "\n");
		for (int i = 0; i < cnt; i++) {
			sb.append(lineIndex.get(i) + "\n");
		}
		System.out.println(sb);

	}

	static void KMP(String tS, String pS) {
		int pi[] = matcing(pS);
		int j = 0;
		for (int i = 0; i < tS.length(); i++) {
			while (j > 0 && tS.charAt(i) != pS.charAt(j)) {
				j = pi[j - 1];
			}
			if (tS.charAt(i) == pS.charAt(j)) {
				if (j == pS.length() - 1) {
					++cnt;
					lineIndex.add(i - j + 1);
					j = pi[j];
				} else
					j++;
			}
		}
	}

	static int[] matcing(String pS) {
		int[] index = new int[pS.length()];
		int j = 0;
		for (int i = 1; i < pS.length(); i++) {
			while (j > 0 && pS.charAt(i) != pS.charAt(j)) {
				j = index[j - 1];
			}
			if (pS.charAt(i) == pS.charAt(j))
				index[i] = ++j;
		}
		return index;
	}

}
