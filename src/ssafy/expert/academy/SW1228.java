package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SW1228 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] initArr = br.readLine().split(" ");
			ArrayList<String> list = new ArrayList<>();
			for (int i = 0; i < initArr.length; i++) {
				list.add(initArr[i]);
			}
			int M = Integer.parseInt(br.readLine());
			String[] insertArr = br.readLine().split("I ");
			for (int i = 1; i < M + 1; i++) {
				String[] temp = insertArr[i].split(" ");
				ArrayList<String> tempList = new ArrayList<String>();
				for (int j = 2; j < temp.length; j++) {
					tempList.add(temp[j]);
				}
				list.addAll(Integer.parseInt(temp[0]), tempList);
			}
			sb.append("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
		br.close();

	}
}
