package ssafy.onlin_learn.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LisTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];// 모든 원소의 값은 다르다.
		int[] lis = new int[n];// 해당길이를 증가수열 중 맨끝을 최소값을 유지
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int size = 0;
		for (int i = 0; i < n; i++) {
			// 중복값이 없으므로 탐색 실패 음수값이 나옴 ==> 삽입위치로 환산
			int temp = Math.abs(Arrays.binarySearch(lis, 0, size, arr[i]) - 1);
			lis[temp] = arr[i];
			if (temp == size)
				++size;

		}
		System.out.println(size);

	}

}
