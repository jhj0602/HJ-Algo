package programmers.level1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class P68644 {
    @Test
    public void 두개뽑아서더하기() throws Exception {
        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(solution(numbers)));

    }

    public int[] solution(int[] numbers) {
        int[] answer = {};
        int len = numbers.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
