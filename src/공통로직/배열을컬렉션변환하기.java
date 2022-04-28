package 공통로직;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class 배열을컬렉션변환하기 {
    @Test
    public void solution() throws Exception {
        int[] numbers = {2, 1, 3, 4, 1};
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < numbers.length; j++) {

            set.add(numbers[j]);
        }
        int[] answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();


        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < numbers.length; j++) {

            list.add(numbers[j]);
        }
        answer = list.stream().mapToInt(i -> i).toArray();
    }
}
