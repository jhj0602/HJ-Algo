package AlgoHot6.week7;

import java.util.HashMap;

public class P81301 {
	public static void main(String[] args) {
		solution("23four5six7");

	}

	public static int solution(String s) {
		String answer = "";
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

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				answer += s.charAt(i);
			} else {
				String temp = "";
				for (int j = i; j < s.length(); j++) {
					temp += s.charAt(j);
					if (map.containsKey(temp)) {
						answer += map.get(temp);
						i = j;
						break;
					}
				}
			}
		}
		return Integer.parseInt(answer);
	}


}
