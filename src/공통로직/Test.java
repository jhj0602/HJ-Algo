package 공통로직;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1]; // i를 제곱수의 합으로 나타낼 경우 최소 항의 갯수 저장

        for(int i=1; i<=n; i++) { //초기화
            dp[i] = i;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        System.out.println(dp[n]);
    }

}
