package programmers.level2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class P42583 {
    @Test
    public void 정답() {
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(2, 10, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        for (int truckWeight : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.offer(truckWeight);
                    max += truckWeight;
                    answer++;
                    break;
                } else if (q.size() == bridge_length) {
                    max -= q.poll();
                } else {
                    if (max + truckWeight > weight) {
                        q.offer(0);
                        answer++;
                    } else {
                        q.offer(truckWeight);
                        max += truckWeight;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
