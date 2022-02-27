package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class P92341 {
    public static void main(String[] args) {
        P92341 p = new P92341();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(p.solution(fees, records));
    }

    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, Integer> result = new TreeMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String x : records) {
            String[] tmp = x.split(" ");
            if (tmp[2].equals("IN")) {
                int min = calc(tmp[0]);
                if (!result.containsKey(tmp[1])) result.put(tmp[1], 0);
                map.put(tmp[1], min);
            } else if (tmp[2].equals("OUT")) {
                int min = calc(tmp[0]);
                result.put(tmp[1], result.get(tmp[1]) + min - map.get(tmp[1]));
                map.remove(tmp[1]);
            }
        }

        if (!map.isEmpty()) {
            for (String key : map.keySet()) {
                result.put(key, result.get(key) + (23 * 60 + 59) - map.get(key));
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();

        for (Integer x : result.values()) {
            if (x <= fees[0]) answer.add(fees[1]);
            else {
                int res = (int) Math.ceil((x - fees[0]) / fees[2]);
                answer.add(fees[1] + res * fees[3]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public int calc(String str) {
        String[] split = str.split(":");
        int min = Integer.parseInt(split[0]) * 60;
        min += Integer.parseInt(split[1]);
        return min;
    }

}
