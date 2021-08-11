package ssafy.expert.academy.tree;

//노드가 숫자인 경우 : 자식 노드가 없어야함
//노드가 연산자인 경우 : 자식 노드가 반드시 있어야함. (숫자+숫자, 연산자+연산자, 연산자+숫자)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1233_사칙연산_유효성검사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());// 노드의 갯수
			char[] tree = new char[N + 1];

			int index = 0;

			// 입력 - 1 - 2 3
			// 뒤 두개의 토큰(왼쪽자식, 오른쪽 자식)은 완전 이진트리 성격을 이용해서 계산 가능하므로 따로 저장 하지 않음.
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				index = Integer.parseInt(st.nextToken());// 노드 번호. 배열의 인덱스로 사용할 거임
				tree[index] = st.nextToken().charAt(0);
			} // 입력

			// N개의 노드에 대해서 조사
			int left, right;
			boolean result = true;

			for (int n = 1; n <= N; n++) {
				left = n * 2;// 왼쪽자식번호
				right = n * 2 + 1;// 오른쪽 자식번호

				if (Character.isDigit(tree[n])) {// 숫자인 경우->자식이 있으면 x
					if (left <= N) {
						result = false;
					}
				} else {// 연산자인 경우- 자식이 o
					if (left <= N && right <= N) {// 왼, 오른쪽 자식이 있고
						if (Character.isDigit(tree[left]) && !Character.isDigit(tree[right])) {// 숫자+연산자
							result = false;
						}
					} else {// 자식이 없는 경우
						result = false;
					}
				} // 연산자인 경우 else

				if (!result)
					break;
			} // for

			System.out.println("#" + tc + " " + (result ? 1 : 0));
		}
	}

}
