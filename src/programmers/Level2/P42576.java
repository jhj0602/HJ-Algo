package programmers.Level2;

import java.util.Arrays;

public class P42576 {

	public static void main(String[] args) {
		P42576 p = new P42576();
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };
		System.out.println(p.solution(participant, completion));

	}

	public String solution(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for (int i = 0; i < participant.length; i++) {
			if(!participant[i].equals(completion[i])){
				return participant[i];
			}
		}
		
		return answer;
	}

}
