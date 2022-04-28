package programmers.level1;

import org.junit.Test;

import java.util.ArrayList;

public class P72410 {
    @Test
    public void 신규_아이디_추천() throws Exception {
        solution("...!@BaT#*..y.abcdefghijklm");
        solution("z-+.^.");
        solution("=.=");
        solution("123_.def");
        solution("abcdefghijklmn.p");


    }

    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (Character.isUpperCase(c) || Character.isLowerCase(c) || Character.isDigit(c)
                    || c == '-' || c == '_' || c == '.') {
                answer += c;
            }
        }
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < answer.length(); i++) {
            list.add(answer.charAt(i));
        }
        for (int i = 1; i < list.size(); ) {
            if (list.get(i - 1) == '.' && list.get(i) == '.') {
                list.remove(i);
                continue;
            }
            i++;
        }
        answer = "";
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        if (!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.substring(1, answer.length());
        }
        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        if (answer.isEmpty()) {
            answer += "a";
        }
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
        }
        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        if (answer.length() <= 2) {
            char c = answer.charAt(answer.length() - 1);
            for (int i = answer.length(); i < 3; i++) {
                answer += c;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
