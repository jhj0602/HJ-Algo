package ssafy.expert.academy.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW1859 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			long benifit = 0;
			long n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int maxIdx =list.size()-1;
			for (int i = list.size()-1; i >=1; i--) {
				if (list.get(i-1) < list.get(maxIdx)) {
					benifit += list.get(maxIdx)-list.get(i-1) ;
				
				}else {
					maxIdx=i-1;
				}
			}
			sb.append("#" + test_case + " " + benifit + "\n");

		}
		System.out.println(sb);
	}

}
