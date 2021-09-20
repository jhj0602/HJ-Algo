package ssafy.onlin_learn.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LISTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] lis = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {// j : i 의 앞쪽원소
				if (arr[j] < arr[i - 1] && lis[j] + 1 > lis[i]) {
					lis[i] =lis[j]+1;
					System.out.print(arr[j]+" lis : "+lis[i]);
				}
				
			}
			System.out.println();
			if(max<lis[i])max= lis[i];
		}
		System.out.println(max);
	}

}
