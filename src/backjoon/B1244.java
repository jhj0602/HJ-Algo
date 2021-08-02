package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
	static int[] arr;
	static int manInit;
	static int womanInit;
	static int num;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchCount = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[switchCount];
		for (int i = 0; i < switchCount; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int people = Integer.parseInt(br.readLine());
		int[][] peopleArr = new int[people][2];
		for (int i = 0; i < people; i++) {
			st = new StringTokenizer(br.readLine());
			peopleArr[i][0] = Integer.parseInt(st.nextToken());// 성별
			peopleArr[i][1] = Integer.parseInt(st.nextToken());// 스위치
			if (peopleArr[i][0] == 1) {
				manInit = peopleArr[i][1];
				manDfs(peopleArr[i][1] - 1);
				continue;
			} else if (peopleArr[i][0] == 2) {
				womanInit = peopleArr[i][1];
				womanDfs(womanInit - 1, 0, 0);
				continue;
			}
		}
		sb.setLength(0);
		for (int i = 0; i < arr.length; i++) {
			// 스위치의 상태를 1번 스위치에서 시작하여 마지막 스위치까지 한 줄에 20개씩 출력한다
			if (i >= 19 && (i + 1) % 20 == 1)
				sb.append("\n");
			sb.append(arr[i]).append(" ");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);

	}

	static void manDfs(int switchNum) {// 남자꺼
		if (switchNum < arr.length) {
			if (arr[switchNum] == 1) {
				arr[switchNum] = 0;
			} else {
				arr[switchNum] = 1;
			}
			manDfs(switchNum + manInit);
		}
		return;

	}

	static void womanDfs(int num, int left, int right) {// 여자꺼
		int dx = num - left;
		int dy = num + right;
		if (dx >= 0 && dy < arr.length) {

			if (arr[num - left] == arr[num + right]) {
				if (arr[num - left] == 1) {
					arr[num - left] = 0;
					arr[num + right] = 0;
				} else {

					arr[num - left] = 1;
					arr[num + right] = 1;
				}
				womanDfs(num, left + 1, right + 1);
			}

		}
		return;
	}

}
