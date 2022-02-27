package programmers.level1;

import java.util.HashMap;

public class P92334 {

    public static void main(String[] args) {
        P92334 p = new P92334();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo",
                "muzi neo", "muzi neo", "apeach muzi"};
        int k = 2;

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;

        System.out.println(p.solution(id_list, report, k));
        p.solution(id_list2, report2, k2);
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> idMap = new HashMap<>();
        for (String s : id_list) {
            idMap.put(s, 0);
        }
        HashMap<String, Integer> reportUser = new HashMap<>();
        HashMap<String, Integer> reportUserCount = new HashMap<>();
        for (String s : report) {
            reportUser.put(s, reportUser.getOrDefault(s, 0) + 1);
            String[] str = s.split(" ");
            if (reportUser.get(s) == 1) {
                reportUserCount.put(str[1], reportUserCount.getOrDefault(str[1], 0) + 1);
            }
        }
        for (String s : reportUser.keySet()) {
            String[] str = s.split(" ");
            if (reportUserCount.get(str[1]) >= k) {
                idMap.put(str[0], idMap.get(str[0]) + 1);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = idMap.get(id_list[i]);
        }
        return answer;
    }
}
