package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean flag = true;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '<') {
					stack.push(str.charAt(i));
				} else if (str.charAt(i) == ')') {
					if (!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else {
						flag = false;
						break;
					}
				} else if (str.charAt(i) == ']') {
					if (!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					else {
						flag = false;
						break;
					}
				} else if (str.charAt(i) == '}') {
					if (!stack.isEmpty() && stack.peek() == '{')
						stack.pop();
					else {
						flag = false;
						break;
					}
				} else if (str.charAt(i) == '>') {
					if (!stack.isEmpty() && stack.peek() == '<')
						stack.pop();
					else {
						flag = false;
						break;
					}
				}
			}
			if (stack.isEmpty() && flag)
				sb.append("#" + test_case + " " + 1 + "\n");
			else
				sb.append("#" + test_case + " " + 0 + "\n");
		}
		System.out.println(sb);
	}

}
