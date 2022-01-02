package programmers.highkit.hash;

import java.util.HashMap;

public class 전화번호목록 {

	public static void main(String[] args) {
		전화번호목록 t = new 전화번호목록();
		String[] phone_book = { "123","456","789" };
		System.out.println(t.solution(phone_book));

	}

	public boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], 1);
		}
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book[i].length(); j++) {
				
				if (map.containsKey(phone_book[i].substring(0,j))) {
					return false;
				}
			}
		}
		System.out.println(map);
		return answer;
	}
}
