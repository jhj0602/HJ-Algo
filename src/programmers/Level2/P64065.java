package programmers.level2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class P64065 {
    @Test
    public void 튜플() throws Exception {
        System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        System.out.println(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
        System.out.println(solution("{{20,111},{111}}"));
    }

    public int[] solution(String s) {
        String[] groups = s.replaceAll("[{}]", " ").trim().split(" ,");
        Arrays.sort(groups, (a, b) -> (a.length() - b.length()));
        int[] answer = new int[groups.length];
        HashSet<Integer> set = new HashSet<>();
        int i=0;
        for (String g : groups) {
            String [] temp = g.trim().split(",");
            for (String t: temp) {
                int num = Integer.parseInt(t);
                if(set.contains(num)) continue;
                set.add(num);
                answer[i++] = num;
            }
        }
        return answer;
    }
}
