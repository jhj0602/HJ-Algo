package backjoon.exhaustive_search.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1256_사전 {
	static int N, M, K, size;
	static String[] temp;
	static String[] str;
	static Set<String> set;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		size = N + M;
		str = new String[size];
		set = new HashSet<String>();
		temp = new String[size];
		isSelected = new boolean[size];
		for (int i = 0; i < N; i++) {
			str[i] = "a";
		}
		for (int i = N; i < str.length; i++) {
			str[i] = "z";
		}
		combination(0, "");
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		System.out.println(list.get(K - 1));
	}

	private static void combination(int cnt, String line) {
		if (cnt == size) {
			set.add(line);
			return;
		}
		for (int i = 0; i < size; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			combination(cnt + 1, line + str[i]);
			isSelected[i] = false;
		}
	}
}
