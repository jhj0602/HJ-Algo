package programmers.level1;

import org.junit.Test;

public class P77884 {
    @Test
    public void 약수의_개수와_덧셈() throws Exception {
        System.out.println(solution(13, 17));
    }

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                if ((i % j) == 0) sum++;
            }
            if (sum % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
}
