package programmers.level2;

import org.junit.Test;

public class P12911 {

    @Test
    public void 정답() {
        System.out.println(solution(78));
        System.out.println(solution2(78));

    }
    //다른사람코드
    public int solution2(int n) {
        int answer = Integer.bitCount(n);

        while(true) {
            n++;
            if(answer == Integer.bitCount(n) ) {
                answer = n;
                break;
            }
        }
        return answer;
    }

    public int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        int cnt = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                cnt++;
            }
        }
        String tempStr = "";
        while (true) {
            n++;
            int tempCnt = 0;
            tempStr = Integer.toBinaryString(n);
            for (int i = 0; i < tempStr.length(); i++) {
                if (tempStr.charAt(i) == '1') {
                    tempCnt++;
                }
            }
            if (cnt == tempCnt) {
                break;
            }
        }
        answer = Integer.parseInt(tempStr, 2);
        return answer;
    }
}
