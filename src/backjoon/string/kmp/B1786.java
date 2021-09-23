package backjoon.string.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1786 {
	static String t, p;
	static int result, arr[];
	static int cnt = 0;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = br.readLine();
		p = br.readLine();
		list = new ArrayList<Integer>();
		arr = new int[p.length()];
		matching();
		KMP();
		sb.append(cnt + "\n");
		for (int i : list) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}

	private static void matching() {
		int j = 0;
		arr = new int[p.length()];
		for (int i = 1; i < p.length(); i++) {
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = arr[j - 1];
			}
			if (p.charAt(i) == p.charAt(j)) {
				arr[i] = ++j;
			}
		}

	}

	private static void KMP() {
		int j = 0;
		for (int i = 0; i < t.length(); i++) {
			while (j > 0 && t.charAt(i) != p.charAt(j)) {
				j = arr[j - 1];
			}
			if (t.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) {
					list.add(i - j + 1);
					cnt++;
					j = arr[j];

				}

				++j;
			}
		}

	}

}
