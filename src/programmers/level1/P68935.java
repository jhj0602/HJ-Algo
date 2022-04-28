package programmers.level1;

import org.junit.Test;

public class P68935 {
    @Test
    public void 진법_뒤집기() throws Exception {
        System.out.println(solution(45));

    }

    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String res = "";
        while (n > 0) {
            res = n % 3 + res;
            n /= 3;
        }
        sb.append(res);
        StringBuilder str = sb.reverse();
        System.out.println(str);

        return answer;
    }
}
