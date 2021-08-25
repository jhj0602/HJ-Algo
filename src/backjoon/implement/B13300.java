package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 학생수
		int K = Integer.parseInt(st.nextToken());// 최대인원수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String S = st.nextToken();// 성별 0 여 1 남
			String Y = st.nextToken();// 학년
//			map.put(S + Y, map.getOrDefault(S + Y, 0) + 1);
		}
		int cnt = 0;
		for (String s : map.keySet()) {
			if (map.get(s) < K + 1) {
				cnt++;
			} else {

				cnt += map.get(s) / K + 1;

			}
		}
		System.out.println(cnt);

	}

}
