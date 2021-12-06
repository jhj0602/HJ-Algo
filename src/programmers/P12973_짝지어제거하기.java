package programmers;

import java.util.Stack;

public class P12973_짝지어제거하기 {
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
	}

	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
}
