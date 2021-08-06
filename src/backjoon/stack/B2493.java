package backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Tower> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력 받은 값들을 하나씩 꺼내어 검색
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			// 스택을 조사 -> 스택 안의 탑의 높이가 더 높아야함
			while (!stack.empty()) {
				if (stack.peek().height >= height) {// 받을 수 있음
					System.out.print(stack.peek().num + " ");
					break;
				}
				// 더 낮은 경우-> 앞으로도 쓸일이 없음
				stack.pop();

			}
			// 28~33 while 문보다 먼저 체크하면 안되는 이유
			// 처음에는 스택에 데이터가 있다가 조건에 안맞아서 pop이 되면 스택이 비는 겨우가 생김
			// 즉 스택에 값이 있어서 조사를 했는데 다 자기보다 낮아서 스택에 비게 된 경우
			if (stack.isEmpty()) {
				System.out.print(0 + " ");
			}

			stack.push(new Tower(i, height));
		}

		System.out.println(sb);

	}

	static class Tower {
		int num;
		int height;

		public Tower(int num, int height) {
			this.num = num;
			this.height = height;
		}
	}
}
