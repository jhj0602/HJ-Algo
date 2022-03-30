// Level2 뉴스 클러스터링
package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;

public class P17677 {

    public static void main(String[] args) {
        P17677 p = new P17677();
        System.out.println(p.solution("aa1+aa2", "AAAA12"));

    }

    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> multiSet1 = new ArrayList<>();
        ArrayList<String> multiSet2 = new ArrayList<>();
        int union = 0;
        int intersection = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for (int i = 1; i < str1.length(); i++) {
            char t1 = str1.charAt(i - 1);
            char t2 = str1.charAt(i);
            if (Character.isAlphabetic(t1) && Character.isAlphabetic(t2)) {
                multiSet1.add(t1 + "" + t2);
            }
        }
        for (int i = 1; i < str2.length(); i++) {
            char t1 = str2.charAt(i - 1);
            char t2 = str2.charAt(i);
            if (Character.isAlphabetic(t1) && Character.isAlphabetic(t2)) {
                multiSet2.add(t1 + "" + t2);
            }
        }
        for (String s : multiSet1) {
            if (multiSet2.remove(s)) {
                intersection++;
            }
            union++;
        }
        union += multiSet2.size();
        double jakard = 0;

        if (union == 0) {
            jakard = 1;
        } else {
            jakard = (double) intersection/ (double) union;
        }
        return (int) (jakard * 65536);
    }
}
