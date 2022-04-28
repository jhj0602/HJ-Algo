package programmers.level1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class P12906 {
    @Test
    public void 같은숫자는싫어() throws Exception {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public int[] solution(int[] arr) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int value = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != value) {
                answerList.add(arr[i]);
                value = arr[i];
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
