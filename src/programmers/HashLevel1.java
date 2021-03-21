package programmers;

import java.util.HashMap;
import java.util.Set;
//완주하지 못한 선수
public class HashLevel1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };
		solution(participant, completion);
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < completion.length; i++) {
			if (map.containsKey(completion[i])) {
				map.put(completion[i], map.get(completion[i]) + 1);

			} else {

				map.put(completion[i], 1);
			}
		}

		for (int i = 0; i < participant.length; i++) {
			if (map.containsKey(participant[i])) {
				if (map.get(participant[i]) > 0) {
					map.put(participant[i], map.get(participant[i]) - 1);
				} else {
					answer = participant[i];
					
					break;
				}
			} else {
				answer = participant[i];
				
				break;
			}
		}
System.out.println(answer);
	
		return answer;
	}

}
