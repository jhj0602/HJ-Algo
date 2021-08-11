package ssafy.expert.academy.tree;

//리프노드는 (자식이 없는 노드:N/2+1~N)숫자이어야 하고
//루트 노드나 내부노드(자식이 있음 1~ㅜ/2) 연산자 이어야함.
//노드가 연산자인 경우 : 자식 노드가 반드시 있어야함. (숫자+숫자, 연산자+연산자, 연산자+숫자)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1233_사칙연산_유효성검사2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());//N
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				//1 - 2 3
				String[] str = br.readLine().split(" ");
				if(i < N/2) {//내부노드->연산자 이어야 됨
					if(str[1].equals("+") || str[1].equals("-") 
							||str[1].equals("*") || str[1].equals("/")) {
						result = 1;
						
					}else {
						result = 0;
					}
				}else {//리프노드->숫자이어야 함
					if(str[1].equals("+") || str[1].equals("-") 
							||str[1].equals("*") || str[1].equals("/")) {
						result = 0;
						
					}
				}				
			}			
			
			System.out.println("#" + tc + " " + result);
		}
	}

}
