package programmers.level2;

import org.junit.Test;

public class P12924 {
    @Test
    public void 숫자의표현() throws Exception {
        System.out.println(solution(15));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }
}
