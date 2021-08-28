package programmers.stack_queue;

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
public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		System.out.println(map);
		for (int i : map.values()) {
			answer *= (i + 1);//입거나 안입거나의 선택지가 있음 옷의 개수에 안입는 거 +1해줌
		}

		System.out.println(answer-1);//하나도 안입는게 없대요
		return answer-1;
	}
}
