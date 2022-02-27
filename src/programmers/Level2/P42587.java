package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class P42587 {

	public static void main(String[] args) {
		P42587 p = new P42587();
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		System.out.println("answer " + p.solution(priorities, 0));
		int[] priorities2 = { 2, 1, 3, 2 };
		System.out.println("answer " + p.solution(priorities2, 2));
	}

	public int solution(int[] priorities, int location) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
	}
}
