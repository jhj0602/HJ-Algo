package backjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11050_B1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int fac = factorial(N);
		int fac2 = factorial(N-K);
		int fac3= factorial(K);
		System.out.println((fac/(fac2*fac3))%10007);
	}

	private static int factorial(int n) {
		  if( n==0 || n==1)
		        return 1;
		return n*factorial(n-1);
	}
}
