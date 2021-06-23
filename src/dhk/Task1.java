package dhk;

import java.util.HashMap;

class Solution {
	public String solution(String S, String C) {
		// write your code in Java SE 8
		String answer = "";
		String[] names = S.split(";");
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		for (String tmp : names) {
			String[] name = tmp.trim().toLowerCase().split(" ");
			String tmpRes = "";
			tmpRes += name[0];
			String lastName = name.length > 2 ? name[2] : name[1];
			lastName = lastName.replaceAll("-", "");
			tmpRes += "." + lastName.substring(0, Math.min(lastName.length(), 8));
			if (data.containsKey(tmpRes)) {
				int idx = data.get(tmpRes);
				data.put(tmpRes, idx + 1);
				answer += tmpRes + String.valueOf(idx + 1);
			} else {
				data.put(tmpRes, 1);
				answer += tmpRes;
			}
			answer += "@" + C.toLowerCase() + ".com; ";
		}
		answer = answer.substring(0, answer.length() - 2);
		return answer;
	}
}

public class Task1 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String S = "John Doe; John Doe; John Doe; John Doe; John Doe";
		String C = "Example";
		System.out.println(s.solution(S, C));
	}

}
