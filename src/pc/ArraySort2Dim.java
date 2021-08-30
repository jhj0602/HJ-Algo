package pc;

import java.util.Arrays;
import java.util.Comparator;
//2차원 배열 정렬
public class ArraySort2Dim {

	public static void main(String[] args) {
		int[][] arr = {{3,5}, {4,2},{3,4}};
		
		//0번 컬럼 기준 오름차순, 혹시 같은 값이면 1번 컬럼 기준 정렬
		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])//정렬 기준 컬럼값이 같으면
					return o1[1] - o2[1];// 1번 컬럼 기준 정렬
				
				else
					return o1[0] - o2[0];//0번 컬럼 기준 오름차순
			}});
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}