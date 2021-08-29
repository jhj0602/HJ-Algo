package backjoon.implement.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			StringBuffer buffer = new StringBuffer(str);
			String reverseStr = buffer.reverse().toString();
			if (str.equals(reverseStr)) {
				sb.append(0+"\n");
			} else {
				boolean flag = false;
				for (int j = 0; j < str.length(); j++) {
					String temp = str.substring(0,j)+str.substring(j+1,str.length());
					String tempReverse = reverseStr.substring(0,reverseStr.length()-1-j)+reverseStr.substring(reverseStr.length()-1-j+1,reverseStr.length());
					if(temp.equals(tempReverse)) {
						flag = true;
						break;
					}
				}
				sb.append(flag? 1:2);
				sb.append("\n");

			}

		}
		System.out.println(sb);

	}
}
