package programmers.level2;

import org.junit.Test;

public class P92342 {
    @Test
    public void 정답() throws Exception {

    }

    static int[] numbers;
    static int[] temp;
    static int max;
    static int[] answer;

    public int[] solution(int n, int[] info) {
        int[] answer = new int[10];
        numbers = new int[n];
        int sum = 0;
        int num = 10;
        for (int i = 0; i < 10; i++) {
            sum += num * info[i];
            num--;
        }
        max = sum;
        comb(0, n);
        answer = temp;
        return answer;
    }

    public void comb(int cnt, int n) {//중복조합
        if (cnt == n) {
            int sum = 0;
            temp = new int[10];
            for (int i = 0; i < n; i++) {
                temp[numbers[i]]++;
                sum += numbers[i] + 1;
            }
            if (max <= sum) {
                max = Math.max(max, sum);
                answer = temp;
            }

            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[cnt] = i;
            comb(cnt + 1, n);

        }
    }
}
