package programmers.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P42586 {

	public static void main(String[] args) {
		P42586 p = new P42586();
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		int[] progresses2 = { 95, 90, 99, 99, 80, 99 };
		int[] speeds2 = { 1, 1, 1, 1, 1, 1 };

		System.out.println(Arrays.toString(p.solution(progresses, speeds)));
		System.out.println(Arrays.toString(p.solution(progresses2, speeds2)));
	}

	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			int cal = 100 - progresses[i];
			int day =  (int) Math.ceil((100.0 - progresses[i]) / speeds[i]); 
			q.offer(day);
		}
		int cnt = 0;
		int temp = q.peek();
		q.poll();
		int []arr = new int[100];
		Arrays.fill(arr, 1);
		arr[0] =1;
		while (!q.isEmpty()) {
			if (temp < q.peek()) {
				temp = q.peek();
				q.poll();
				cnt++;
			}else {
				arr[cnt]++;
				q.poll();
			}
		}
		int[] answer = new int[cnt+1];
		for (int i = 0; i < cnt+1; i++) {
			answer[i] = arr[i];
		}
		return answer;
	}

}
