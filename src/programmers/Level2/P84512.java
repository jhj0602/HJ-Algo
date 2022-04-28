package programmers.level2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class P84512 {
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    static boolean[] isSelected;
    static String[] temp;
    static ArrayList<String> list = new ArrayList<>();

    @Test
    public void 정답답() throws Exception {
//        solution("AAAAE");
//        solution("AAAE");
       solution("EIO");
//        solution("I");

    }

    public int solution(String word) {
        int answer = 0;
        isSelected = new boolean[5];
        for (int i = 1; i <= 5; i++) {
            temp = new String[i];
            permutation(0, i);
        }
        Collections.sort(list);
//        System.out.println(list);
        System.out.println(list.indexOf(word)+1);
        return answer;
    }


    private static void permutation(int cnt, int N) {
        if (cnt == N) {
            list.add(String.join("", temp));
            return;
        }
        for (int i = 0; i < 5; i++) {
            temp[cnt] = String.valueOf(alphabet[i]);
            permutation(cnt + 1, N);
        }
    }
}