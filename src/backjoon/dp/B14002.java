package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class B14002 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] lis = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			lis[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;

				}
			}
			
			max = Math.max(lis[i], max);

		}
		int value = max;
		Stack <Integer> stack = new Stack<>();
		for (int i = n; i >=1; i--) {
			if(value ==lis[i]) {
				stack.push(arr[i]);
				value--;
			}
		}
		sb.append(max + "\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.println(sb);
	}

}
