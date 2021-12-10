//Level2 오픈채팅방
package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P42888 {

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));

	}

	public static String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<String> list = new ArrayList<>();
		int answerCount = 0;
		for (int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			System.out.println(str.length);

			if (str[0].equals("Enter")) {
				list.add(str[1] + " 님이 들어왔습니다.");
				map.put(str[1], str[2]);
				answerCount++;

			} else if (str[0].equals("Leave")) {
				list.add(str[1] + " 님이 나갔습니다.");
				map.put(str[1], map.get(str[1]));
				answerCount++;
			} else {
				map.put(str[1], str[2]);
			}

		}
		String[] answer = new String[answerCount];
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(" ");
			answer[i] = map.get(str[0]) + str[1]+" "+str[2];
		}

		return answer;
	}
}
