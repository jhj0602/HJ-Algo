package highscorekit;

import java.util.HashMap;

public class HashLevel2_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		String[][] clothes2 = { { "yellowhat", "face" }, { "bluesunglasses", "face" }, { "green_turban", "face" },
				{ "zz", "zz" } };

		solution(clothes);
		solution(clothes2);

	}
	// 1.해시 종류 : 갯수 값 입력 받기
	// 2. getOrDefault 메소드 첫번째 인자의 값이 Map에 존재하지 않는다면 Default로 설정한 값으로 가져옴 null방지

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		System.out.println(map);
		for (int i : map.values()) {
			answer *= (i + 1);
			
		}

		System.out.println(answer-1);
		return answer-1;
	}
}
