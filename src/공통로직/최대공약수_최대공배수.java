package 공통로직;

import org.junit.Test;

public class 최대공약수_최대공배수 {
    @Test
    public void solution() throws Exception {
        System.out.println(gcd(8,30));
        System.out.println(lcm(8,30));

    }

    int gcd(int a, int b) { // 최대공약수
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    int lcm(int a, int b) { // 최소 공배수
        // 0이 아닌 두 수의 곱 / 두 수의 최대공약수
        return a * b / gcd(a, b);
    }
}
