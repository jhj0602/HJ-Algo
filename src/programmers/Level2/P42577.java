package programmers.level2;

import org.junit.Test;

import java.util.HashMap;

public class P42577 {
    @Test
    public void 정답() throws Exception {
        String[] phone_book = {"119", "97674223", "1195524421"};
        solution(phone_book);
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
        return answer;
    }
}
