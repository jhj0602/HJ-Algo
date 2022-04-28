package programmers.level2;

import org.junit.Test;

public class P12953 {
    @Test
    public void N개의최소공배수() throws Exception {
        int[] arr = {1, 2, 3};
        solution(arr);
    }

    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }

    int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
