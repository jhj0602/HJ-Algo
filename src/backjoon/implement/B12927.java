package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = " " + br.readLine();
		char[] arr = s.toCharArray();
		int idx = 0;
		int cnt = 0;
		for(int i=1; i<arr.length; i++) {
			if(arr[i]=='N') continue;
			for(int j=i; j<arr.length; j+=i) {
				if(arr[j]=='N') arr[j] = 'Y';
				else if(arr[j]=='Y') arr[j] = 'N';
			}
			cnt++;
		}
		System.out.println(cnt);

	}

}
