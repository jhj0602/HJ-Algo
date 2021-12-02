package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class B1245 {
	static String[] str;
	static char[] temp;
	static boolean[] isSelected;
	static HashMap<String, Integer> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}
		for (int i = 0; i < n; i++) {
			temp = new char[str[i].length()];
			isSelected = new boolean[str[i].length()];
			map = new HashMap<>();
			comb(0, 0, str[i]);
			ArrayList<String> list = new ArrayList<>(map.keySet());
			Collections.sort(list);
			for (String s : list) {
				sb.append(s + "\n");
			}
		}
		System.out.println(sb);
	}

	private static void comb(int cnt, int start, String s) {
		if (cnt == s.length()) {
			map.put(String.valueOf(temp), 1);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if (isSelected[i])
				continue;
			temp[cnt] = s.charAt(i);
			isSelected[i] = true;
			comb(cnt + 1, i + 1, s);
			isSelected[i] = false;
		}
	}
}
