package programmers;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    @Test
    public void 정답() {
        Solution s = new Solution();
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(s.solution(2, 10, truck_weights));

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int sum =0;
        int time =0;
        for (int w : truck_weights ) {
            while (true){
                if(q.isEmpty()) {
                    q.offer(w);
                    sum += w;
                    time++;
                }else if(q.size()==bridge_length){
                    sum-=q.poll();
                }else{
                    if(sum+w>weight){
                        q.offer(0);
                        time++;
                    }else{
                        q.offer(w);
                        sum+=w;
                        time++;
                        break;
                    }
                }
            }

        }
        return time+bridge_length;
    }
}