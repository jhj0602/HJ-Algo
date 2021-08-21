package pc.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//한 행에 하나의 퀸 즉 같은 행에 두지 않는 방식
// N개의 퀸을 위협적이지 않게 놓는 모든 경우의 수
public class nQueen_백트레킹2 {
	static int N,cnt;
	static int col[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N + 1];// 1행 2행 3행 4행 ~~N행
		setQueens(1);// 1행부터
		System.out.println(cnt);
	}

	private static void setQueens(int rowNo) {// 매개변수는 행번호

		// 유망 여부 체크 : rowN - 1 행 까지 유망한지 체크
	

		if (rowNo > N) {
			cnt++;
			return;
		}
		// 현재 퀸 1열부터 N열까지 놓아보기
		// 놓았으면 다음 퀸 놓으러 가기
		for (int i = 1; i <=N; i++) {
			col[rowNo] = i;// i열에 놓아보기
			if (isAvailable(rowNo)) {
				setQueens(rowNo + 1);
			}
			
		}
	}

	private static boolean isAvailable(int rowNo) {
		for (int i = 1; i < rowNo; i++) {// i는 이전퀸 // 행차이 열차이 공식 Math.abs(col[rowNo]) - col[i] == (rowNo - i)
			if (col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == (rowNo - i)) {// 같은 행에 있다면 false 반환 //열의 차이 값이 행의 차이 값과 같다면 대각선에 있음
				return false;
			}
		}
		return true;
	}
}
