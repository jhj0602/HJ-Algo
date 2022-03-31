package programmers.level2;

import org.junit.Test;

public class P12985 {

    @Test
    public void 정답() {
        System.out.println(solution(8, 4, 7));
    }

    public int solution(int n, int a, int b) {
        int answer = 0;
        while (true) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            System.out.println(a + " " + b);
            answer++;
            if (a == b) break;
        }
        return answer;
    }
}
