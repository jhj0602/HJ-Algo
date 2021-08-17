package backjoon.gridy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Integer.parseInt(br.readLine());
		long sum=0;
		int i=1;
		while(S>=sum) {
			sum+=i++;
		}
		System.out.println(S==sum? i : i-1);

	}

}
