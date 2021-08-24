package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		char[] arr = (br.readLine() + "\n").toCharArray();
		int N = arr.length;
		boolean tag = false;
		for (int i = 0; i < N; ++i) {
			char c = arr[i];
			if (c == '<')
				tag = true;

			if (tag || c == ' ' || c == '\n') {
				while (!stack.isEmpty())
					sb.append(stack.pop());
				if (c != '\n')
					sb.append(c);
			} else {
				stack.push(c);
			}
			if (c == '>')
				tag = false;
		}
		System.out.println(sb);
	}

}
