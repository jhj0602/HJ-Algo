package ssafy.expert.academy.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW1223 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int len = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			Stack<Integer> s = new Stack<Integer>();
			s.push(Integer.parseInt(temp.charAt(0) + ""));
			for (int i = 1; i < len - 1; i += 2) {
				if (temp.charAt(i) == '+')
					s.push(Integer.parseInt(temp.charAt(i + 1) + ""));
				else
					s.push(s.pop() * Integer.parseInt(temp.charAt(i + 1) + ""));
			}
			int result = 0;
			while (!s.isEmpty())
				result += s.pop();
			sb.append("#" + test_case + " " + result+"\n");

		}
		System.out.println(sb);
	}
}
