package backjoon.exhaustive_search.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1010 {
static int count;
static int [] temp;
static int N,M;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 M = Integer.parseInt(st.nextToken());
			count=0;
			comb(0,0);
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
	private static void comb(int cnt,int start) {
		if(cnt==N) {
			count++;
			return;
		}
		for (int i = start; i < M; i++) {
		
			comb(cnt + 1, i + 1);
		}
		
	}

}
