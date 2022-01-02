package programmers.highkit.hash;

import java.util.HashMap;

public class 위장 {

	public static void main(String[] args) {
		위장 p = new 위장();
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(p.solution(clothes));

		String[][] clothes2 = { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } };
		System.out.println(p.solution(clothes2));
	}

	 public int solution(String[][] clothes) {
	       int answer = 1;
	        HashMap<String, Integer> clothesMap = new HashMap<>(); 
	        for (int i = 0; i < clothes.length; i++) {
	            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);
	        }
	        for (int val : clothesMap.values()){
	            answer *= (val+1);
	        }
	        return answer-1;
	    }

}
