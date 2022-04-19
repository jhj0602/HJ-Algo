package programmers.level2;

import org.junit.Test;

public class P92335 {
    @Test
    public void 정답() {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));

    }

    public int solution(int n, int k) {
        int answer = 0;
        String convertNum = kBinary(n, k);
        String[] str = convertNum.split("0");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("")) {
                continue;
            }
            if (isPrime(Long.parseLong(str[i]))) answer++;
        }
        return answer;
    }

    public String kBinary(int n, int k) {
        String res = "";
        while (n > 0) {
            res = n % k + res;
            n /= k;
        }
        return res;
    }

    public boolean isPrime(long num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
