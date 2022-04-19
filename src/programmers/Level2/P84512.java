package programmers.level2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P84512 {
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    static boolean[] isSelected;
    static ArrayList<String> list = new ArrayList<>();

    @Test
    public void 정답답() throws Exception {
        solution("AAAAE");

    }

    public int solution(String word) {
        int answer = 0;
        isSelected = new boolean[5];
        subset(0);
        Collections.sort(list);
        return answer;
    }

    private static void subset(int cnt) {// 부분집합 구하기
        if (cnt == 5) {// 하나의 부분집합이 완성 됐을 때 할일.
            String temp = "";
            for (int i = 0; i < 5; i++) {
                temp += isSelected[i] ? alphabet[i] : "";
            }
            System.out.println(temp);
            list.add(temp);
            return;
        }

        // 현재 원소를 부분집합에 넣기
        isSelected[cnt] = true;
        subset(cnt + 1);
        // 현재 원소를 부분집합에 넣지 않기
        isSelected[cnt] = false;
        subset(cnt + 1);
    }
}


//    private static void comb(int cnt) {//중복조합
//        if (cnt == 5) {
//            System.out.println(Arrays.toString(temp));
//            return;
//        }
//        for (int i = 0; i < 5; i++) {
//            temp[cnt] =alphabet[i];
//            comb(cnt + 1);
//
//        }
//    }