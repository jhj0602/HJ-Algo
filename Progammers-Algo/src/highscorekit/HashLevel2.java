package highscorekit;

import java.util.Arrays;

public class HashLevel2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = { "119", "97674223", "1195524421" };
		String[] phone_book3 = { "123", "456", "789" };
		String[] phone_book2 = { "12", "123", "1235", "567", "88" };
		solution(phone_book);
		solution(phone_book3);

		solution(phone_book2);

	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				answer = false;
				break;
			}
		}

		return answer;
	}

}
