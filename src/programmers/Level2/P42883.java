package programmers.level2;

import org.junit.Test;

public class P42883 {
    @Test
    public void 정답() {
        System.out.println(solution("1924", 2));
    }

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int max = 0;
        int index = 0;
        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = index; j <= i + k; j++) {
                int temp = number.charAt(j) - '0';
                if (max < temp) {
                    max = temp;
                    index = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
