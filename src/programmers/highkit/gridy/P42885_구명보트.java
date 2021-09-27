package programmers.highkit.gridy;

import java.util.Arrays;

public class P42885_구명보트 {
	public static void main(String[] args) {
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		solution(people, limit);
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);
		int last = people.length-1;
		for (int i = 0; i < people.length; i++) {
			if(people[i]+people[i+1]<=limit) {
				answer++;
				last--;
			}else {
				answer++;
			}
		}



		System.out.println(answer);
		return answer;
	}
}
