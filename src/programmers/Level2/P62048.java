package programmers.level2;

import org.junit.Test;
//다시풀기
public class P62048 {

    @Test
    public void 정답() {
        System.out.println(solution(4, 3));
        System.out.println(solution(5, 4));
        System.out.println(solution(8, 12));
        System.out.println(solution(4, 4));
        System.out.println(solution(4, 4));
    }

    public long solution(int w, int h) {
        long answer = 0;

        for (int i = 0; i < w; i++) {
            answer += h * i / w;
        }

        return answer * 2;
    }
}
