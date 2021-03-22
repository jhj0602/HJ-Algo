package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4796 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		StringTokenizer st;
		int cnt=1;
		while (true) {
			st = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if (l == 0 )break;
			

			
			sb.append("Case "+cnt+": "+((v/p)*l+Math.min(l,v%p))+"\n");
			cnt++;
			
		}
		System.out.println(sb);
	}
}
