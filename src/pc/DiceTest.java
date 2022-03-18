package pc;

import java.util.Arrays;
import java.util.Scanner;

//중복조합 nHr n =6 r =6  nHr = 6H3  = 6+3-1C3 
public class DiceTest {
    static int N, numbers[], totalCnt;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        int M = sc.nextInt();
        switch (M) {
            case 1:// 주사위 던저기 1 : 중복 순열
                dice1(0);
                break;
            case 2:// 주사위 던지기2 : 순열
                isSelected = new boolean[7];
                dice2(0);
                break;
            case 3:// 주사위 던지기3: 중복조합
                dice3(0);
                break;
            case 4:// 주사위 던지기4 : 조합
                dice4(0, 1);
                break;
        }

        System.out.println("경우의 수:" + totalCnt);

    }

    private static void dice1(int cnt) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 1; i <= 6; i++) {
            numbers[cnt] = i;
            dice1(cnt + 1);
        }
    }

    private static void dice2(int cnt) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 1; i <= 4; i++) {
            // 중복체크
            if (isSelected[i])
                continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            dice2(cnt + 1);
            isSelected[i] = false;

        }
    }

    private static void dice3(int cnt) {//중복조합
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 1; i <= 4; i++) {

            numbers[cnt] = i;
            dice3(cnt + 1);

        }
    }


    private static void dice4(int cnt, int start) {
        if (cnt == N) {
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = start; i <= 4; i++) {
            numbers[cnt] = i;
            dice4(cnt + 1, i + 1);

        }
    }

}
