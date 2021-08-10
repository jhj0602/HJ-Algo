package ssafy.expert.academy.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SW1204 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			HashMap<Integer, Integer> map = new HashMap<>();
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int x = Integer.parseInt(st.nextToken());
				map.put(x, map.getOrDefault(x, 0) + 1);
			}
		
			ArrayList<Integer> listKeySet = new ArrayList<>(map.keySet());
			Collections.sort(listKeySet, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
			int maxValue = map.get(listKeySet.get(0));
			ArrayList<Integer> sameList = new ArrayList<>();
			for (int i : listKeySet) {
				if (maxValue == map.get(i)) {
					sameList.add(i);
				} else {
					break;
				}
			}
			Collections.reverse(sameList);

			sb.append("#" + t + " " + sameList.get(0) + "\n");
		}
		System.out.println(sb);
		br.close();
	}

}
