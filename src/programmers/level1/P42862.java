package programmers.level1;

import org.junit.Test;

import java.util.Arrays;

public class P42862 {
    @Test
    public void 정답() {
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(5, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        for (int i : lost) {
            arr[i] = 0;
        }
        int reserveCnt=0;
        for (int i : reserve) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 2;
                reserveCnt++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < reserve.length; j++) {
            int front = reserve[j] - 1;
            int back = reserve[j] + 1;
            int idx = reserve[j];
            if ( reserveCnt>0&&arr[idx] == 2 && front > 0 && back < n + 1) {
                if (arr[front] == 0) {
                    arr[front] = 1;
                    arr[idx] = 1;
                    reserveCnt--;
                } else if (arr[back] == 0) {
                    arr[back] = 1;
                    arr[idx] = 1;
                    reserveCnt--;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] > 0) {
                answer++;
            }
        }

        System.out.println(Arrays.toString(arr));
        return answer;
    }
}
