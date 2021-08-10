package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SW1229 {

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
			String[] arr = br.readLine().split(" ");
			System.out.println(Arrays.toString(arr));
			for (int i = 0; i < arr.length; i++) {
				System.out.println(i+ "  "+arr[i]);
				
				if (arr[i].equals("I")) {

					int cnt = Integer.parseInt(arr[i+2]) + 2;
					ArrayList<String> tempList = new ArrayList<String>();
					for (int j = i+2; j < cnt+1 ; j++) {
						tempList.add(arr[j]);
					}
					System.out.println(tempList.size());
					list.addAll(Integer.parseInt(arr[i+1]), tempList);
					i = tempList.size()+3;
					
				

				} else if (arr[i].equals("D")) {
					int cnt = Integer.parseInt(arr[i+1]);
					for (int j = Integer.parseInt(arr[i+1]); j < Integer.parseInt(arr[i+2]);j++) {
						list.remove(cnt);
					}
					i += 3;

				}
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
