package backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14891_톱니바퀴 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] dirArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < 4; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < str.length; j++) {
				list.get(i).add(Integer.parseInt(str[j]));
			}
		}
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		int num, dir;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken()) - 1;
			dir = Integer.parseInt(st.nextToken());
			dirArr = new int[4]; // 방향 배열 초기화
			dirArr[num] = dir;

			checkL(num-1, dir * -1); // 좌측 탐색
			checkR(num+1, dir * -1); // 우측 탐색
			for (int j = 0; j < dirArr.length; j++)
				rotate(j, dirArr[j]); // 회전 방향 모두 설정한 후 톱니바퀴를 회전시킨다
		}

		int sum = 0;

		for (int i = 0; i < 4; i++) {// sum
			if (list.get(i).get(0) == 1) {
				sum += Math.pow(2, i);
			}

		}
		System.out.println(sum);
	}

    static void checkR(int idx, int dir) {
        if (idx > 3) return;

        if (list.get(idx).get(6)!= list.get(idx-1).get(2)) {
        	checkR(idx + 1, -dir);
            
        }
    }

	private static void checkL(int idx, int dir) {
        if (idx < 0) return;
        if (list.get(idx).get(2)!= list.get(idx+1).get(6)) {
        	checkL(idx - 1, -dir);
           
        }
    }

	private static void rotate(int num, int dir) {
		int temp=0;
		if (dir == 1) {
			 temp = list.get(num).get(7);
			list.get(num).remove(7);
			list.get(num).add(0, temp);
		} else {
		 temp = list.get(num).get(0);
			list.get(num).remove(0);
			list.get(num).add(7, temp);
		}

	}

}
