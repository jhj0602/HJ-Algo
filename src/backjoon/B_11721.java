package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11721 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder sb=new StringBuilder();
		int cnt=1;
		for(int i=0;i<line.length();i++) {
			if(i-(10*cnt)==0) {
				cnt++;
				sb.append("\n");
			}
			sb.append(line.charAt(i));
		}
				System.out.println(sb);

	}

}
