package programmers.kakao.intern2021;

import java.util.HashMap;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("123");

	}

	public static int solution(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				result += s.charAt(i);
			} else {
				String temp = "";
				while (true) {
					temp += s.charAt(i);
					if (map.containsKey(temp)) {
						result += map.get(temp);
						break;
					}
					i++;
				}
			}
		}
		return Integer.parseInt(result);
	}
}
