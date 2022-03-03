package programmers.level1;

import org.junit.Test;

import java.util.HashMap;

public class P42862 {
    @Test
    public void 정답() {
        int[] lost = {3};
        int[] reserve = {1};
        System.out.println(solution(3, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer=0;
        int size = lost.length + reserve.length;
        if (n >= size) {
            answer = n - size;

        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < lost.length; i++) {
            map.put(lost[i], 0);
        }
        for (int i = 0; i < reserve.length; i++) {
            if (map.containsKey(reserve[i])) {
                map.put(reserve[i], 1);
                continue;
            }
            map.put(reserve[i], 2);
        }

        for (int l : lost) {
            for (int r : reserve) {
                if (map.get(r) == 2 && map.get(l) == 0 &&
                        (r == l - 1 || r == l + 1)) {
                    map.put(l, 1);
                    map.put(r, 1);
                }
            }
        }

        for (int m : map.keySet()) {
            if (map.get(m) >= 1) {
                answer++;
            }
        }
        return answer;
    }
}
