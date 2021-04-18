package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int t = 0; t < testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Integer> importance = new LinkedList<Integer>(); // 중요도가 들어간 배열
			int[] sortArr = new int[N]; // 중요도를 오름차순으로 정렬하기 위한 배열

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int importanceNum = Integer.parseInt(st.nextToken());
				importance.add(importanceNum);
				sortArr[i] = importanceNum;
			}
			Arrays.sort(sortArr);
			int importanceOrder = sortArr.length - 1;
			int order = 0;
			int calCount = 0;

			while (true) {
				int pollNum = importance.poll();

				if (calCount == M) {
					pollNum += 101;
				}
				calCount++;

				if (sortArr[importanceOrder] == pollNum - 101) {
					order++;
					bw.write(String.valueOf(order));
					bw.newLine();
					break;

				} else if (sortArr[importanceOrder] == pollNum) {
					order++;
					importanceOrder--;
				} else {
					importance.add(pollNum);
				}
			}
		}
		bw.flush();
	}
}
