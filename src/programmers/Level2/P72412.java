package programmers.level2;

import org.junit.Test;

import java.util.HashMap;

public class P72412 {
    @Test
    public void 정답() {
        P72412 p = new P72412();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        solution(info, query);
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String[] str = info[i].split(" ");
            map.put(str[0] + " " + str[1] + " " + str[2] + " " + str[3], Integer.parseInt(str[4]));
        }

        System.out.println(map.containsKey("java"));
        System.out.println(map);
        return answer;
    }

}
