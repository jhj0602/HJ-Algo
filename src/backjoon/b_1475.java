package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] arr = new int[10];
//계수 정렬
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '6' || line.charAt(i) == '9') {
				arr[6]++;
			}
			else {
				arr[line.charAt(i)-'0']++;
			}
		}
		arr[6] = arr[6]%2==1 ? arr[6]/2+1 : arr[6]/2;
		
		int max = 0;
		for (int i : arr) {
			max = Math.max(max, i);
		}
		System.out.println(max);

	}

}
