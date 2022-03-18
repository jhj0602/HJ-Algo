package pc;

import java.util.Arrays;

//nCr : n개 중에 r개를 선택 중복 x
public class CombinationTestWebX {
	static int N, R;
	static int[] nums, selected;
	static int totalCount;// 완성된 조합의 갯수

	public static void main(String[] args) {
		N = 5;// 총 숫자들
		R = 4;// 뽑을 숫자
		nums = new int[] { 1, 2, 3, 4, 5 };
		selected = new int[R];// 뽑힌 값들이 저장될 배열
		combination(0, 0);
		System.out.println("총 경우의 수 :" + totalCount);
	}

//cnt: 이제껏 뽑은 숫자의 갯수 ,start: 선택할 위치
	private static void combination(int cnt, int start) {
		if (cnt == R) {// 다 뽑았음
			totalCount++;
			System.out.println("zzzzzzzzz");
			System.out.println(Arrays.toString(selected));// 뽑힌 숫자들
			return;
		}
		
		
		// 뽑아야 됨
		for (int i = start; i < N; i++) {
			selected[cnt] = nums[i];
			System.out.println(cnt+"  cnt nums :" + nums[i]);
			combination(cnt + 1, i + 1);
			
		}
	
	}

}
