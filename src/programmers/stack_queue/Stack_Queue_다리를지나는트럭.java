package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_Queue_다리를지나는트럭 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		System.out.println(solution(bridge_length, weight, truck_weights));

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<Integer>();// 다리를건너는
		for(int i :truck_weights) {
			
		}

		return answer + bridge_length;

	}

}
