package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2841_크게만들기_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int temp = K;
		String[] str = br.readLine().split("");
		stack.push(Integer.parseInt(str[0]));
		for (int i = 1; i < N; i++) {
			int num = Integer.parseInt(str[i]);
			while (temp > 0 && !stack.isEmpty() && stack.peek() < num) {
				stack.pop();
				temp--;
			}
			if (stack.size() != N - K) {
				stack.push(num);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.reverse());
	}

}
