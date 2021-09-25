package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J1681 {
	static int[][] matrix;
	static int N;
	static int ans;
	static boolean[] visited;
	static int temp[];
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
		temp = new int [N];
		dfs(0,0,0);
		System.out.println(ans);
		
	}
	static void dfs(int idx, int cnt, int distance) {
		System.out.println(distance);
		if(distance>=ans) return;
		
		if(cnt == N-1) {
			if(matrix[idx][0]!=0) {
				int temp2 = distance + matrix[idx][0];
				System.out.println(Arrays.toString(temp)+" "+temp2);
				ans = Math.min(ans, temp2);
			}
			return;
		}
		
		for(int i=1;i<N;i++) {
			if(!visited[i] && matrix[idx][i]!=0) {
				visited[i] = true;
				temp[cnt] =i;
				dfs(i, cnt+1, distance + matrix[idx][i] );
				visited[i] =false;
			}
		}
	}
}
