package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1681 {
	static int[][] matrix;
	static int N;
	static int ans;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 배달 장소 수
		matrix = new int[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		visited= new boolean[N];
		
		dfs(0,0,0);
		System.out.println(ans);
		
	}
	static void dfs(int idx, int cnt, int distance) {
		if(distance>=ans) return;
		
		if(cnt == N-1) {
			if(matrix[idx][0]!=0) {
				int temp = distance + matrix[idx][0];
				ans = Math.min(ans, temp);
			}
			return;
		}
		
		for(int i=1;i<N;i++) {
			if(!visited[i] && matrix[idx][i]!=0) {
				visited[i] = true;
				dfs(i, cnt+1, distance + matrix[idx][i] );
				visited[i] =false;
			}
		}
	}
}
