package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2960 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
	
		boolean[] check = new boolean[n+1];
		int cnt = 0;
    	for(int i = 2; i<=n; i++) {
    		for(int j = i; j<=n; j+=i) {
    			if(check[j] == false) {
        			cnt++;
        			check[j] = true;
    			}

    			if(cnt == k) {
    				System.out.println(j);
    				System.exit(0);
    			}
    		}
    	}
	}


}
