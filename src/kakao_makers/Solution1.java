package kakao_makers;

import java.util.HashSet;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gift_cards = { 4, 5, 3, 2, 1 };
		int[] wants = { 2, 4, 4, 5, 1 };
		int[] gift_cards2 = { 5, 4, 5, 4, 5 };
		int[] wants2 = { 1, 2, 3, 5, 4 };
		int[] gift_cards3 = { 1, 2, 3, 4, 5 };
		int[] wants3 = { 3, 4, 5, 5, 6 };
//
//		System.out.println(solution(gift_cards, wants));
//		System.out.println(solution(gift_cards2, wants2));
		System.out.println(solution(gift_cards3, wants3));
	}

	public static int solution(int[] gift_cards, int[] wants) {
		int answer = 0;
		HashSet<Integer> giftSet = new HashSet<Integer>();
		HashSet<Integer> wantSet = new HashSet<Integer>();
		for (int i : gift_cards) {
			giftSet.add(i);
		}
		for (int i : wants) {
			wantSet.add(i);
		}
		giftSet.retainAll(wantSet);
		answer = wants.length - giftSet.size();
		return answer;
	}

}
