package programmers.level1;

import org.junit.Test;

import java.util.Arrays;

public class P42576 {
    @Test
    public void 정답() throws Exception {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        solution(participant, completion);
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int cnt = 0;
        for (int i = 0; i < participant.length; i++) {
            if (participant[i].equals(completion[cnt])) {
                return participant[i];
            }
        }
        return answer;
    }
}

