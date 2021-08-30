package ssafy.expert.academy.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1208 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int dump = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] arr = new int[100];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Arrays.sort(arr);
	
			for (int i = 0; i < dump; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr);
				sb.append(arr[99] - arr[0]+"\n");
		}
		System.out.println(sb);
		br.close();

	}
}
