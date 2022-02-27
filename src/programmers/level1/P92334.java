package programmers.level1;

import java.util.HashMap;

public class P92334 {

    public static void main(String[] args) {
        P92334 p = new P92334();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo",
                "muzi frodo","muzi neo", "apeach muzi"};
        int k = 2;
        p.solution(id_list, report, k);
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        HashMap<String, Integer> reportUser = new HashMap<>();
        HashMap<String, Integer> reportUserCount = new HashMap<>();
        for (String s : report) {
            reportUser.put(s, reportUser.getOrDefault(s, 0) + 1);
        }
        System.out.println(reportUser);
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");


        System.out.println();
        return answer;
    }
}
