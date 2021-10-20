package programmers.highkit.hash;

import java.util.HashMap;

public class P42579 {

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		solution(genres, plays);
	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		HashMap<String, Integer> genre = new HashMap<String, Integer>();
		for (int i = 0; i < genres.length; i++) {
			genre.put(genres[i], genre.getOrDefault(genres[i], 0) + 1);
		}
		return answer;
	}
}
