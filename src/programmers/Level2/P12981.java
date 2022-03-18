package programmers.level2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class P12981 {
    @Test
    public void 정답() {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution(3, words)));
        System.out.println(Arrays.toString(solution(5, words2)));
        System.out.println(Arrays.toString(solution(2, words3)));
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String, Integer> wordMap = new HashMap<>();
        int peopleNum = 1;
        String str = words[0];
        wordMap.put(str, 1);
        for (int i = 1; i < words.length; i++) {
            if (str.charAt(str.length() - 1) != words[i].charAt(0) || wordMap.containsKey(words[i])) {
                answer[0] = peopleNum % n + 1;
                answer[1] = peopleNum / n + 1;
                return answer;
            } else {
                peopleNum++;
                str = words[i];
                wordMap.put(str, 1);
            }
        }
        return answer;
    }
}
