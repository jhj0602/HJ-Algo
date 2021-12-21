//level2 더 맵게 힙
package programmers.Level2;

import java.util.PriorityQueue;

public class P42626 {

	public static void main(String[] args) {
		P42626 p = new P42626();
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		System.out.println(p.solution(scoville, 7));

	}

	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			pq.offer(scoville[i]);
		}
		
		while (pq.peek()<=K) {
            if(pq.size()==1){
                return -1;
            }
			answer++;
			int first = pq.poll();
			int second = pq.poll();
			pq.add(first + (second * 2));
		}
		return answer;
	}
}
