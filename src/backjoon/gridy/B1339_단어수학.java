package backjoon.gridy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class B1339_단어수학 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		HashMap<Integer, HashMap<Character, Integer>> bigMap = new LinkedHashMap<Integer, HashMap<Character, Integer>>();
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
			HashMap<Character, Integer> smallMap = new LinkedHashMap<Character, Integer>();
			for (int j = 0; j < str[i].length(); j++) {
				smallMap.put(str[i].charAt(j), smallMap.getOrDefault(str[i].charAt(j), 0) + 1);
			}
			bigMap.put(i, smallMap);
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			String temp = "";
			for (Character c : bigMap.get(i).keySet()) {
//				System.out.println(c + " " + bigMap.get(i).get(c));
				int charCount = bigMap.get(i).get(c);
				char isChar = c;
				if (isChar == 'A' || isChar == 'B' || isChar == 'C' || isChar == 'D' || isChar == 'E' || isChar == 'F'
						|| isChar == 'G') {
					if (c == 'A') {
						for (int j = 0; j < charCount; j++) {
							temp += "9";
						}
					} else if (c == 'B') {
						for (int j = 0; j < charCount; j++) {
							temp += "4";
						}
					} else if (c == 'C') {
						for (int j = 0; j < charCount; j++) {
							temp += "8";
						}
					} else if (c == 'D') {
						for (int j = 0; j < charCount; j++) {
							temp += "6";
						}
					} else if (c == 'E') {
						for (int j = 0; j < charCount; j++) {
							temp += "5";
						}
					} else if (c == 'F') {
						for (int j = 0; j < charCount; j++) {
							temp += "3";
						}
					} else if (c == 'G') {
						for (int j = 0; j < charCount; j++) {
							temp += "7";
						}
					}
				}
				System.out.println(temp);

			}
			sum += Integer.parseInt(temp);
		}
		System.out.println(sum);
	}

}
