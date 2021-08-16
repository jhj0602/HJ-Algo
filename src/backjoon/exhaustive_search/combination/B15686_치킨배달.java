package backjoon.exhaustive_search.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686_치킨배달 {
	static int[][] arr;
	static int N, M;
	static ArrayList<Dot> chicken;
	static ArrayList<Dot> house;
	static Dot[] temp;
	static int wholeMin = Integer.MAX_VALUE;// 전체 최솟값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());// 뽑는 수
		arr = new int[N + 1][N + 1];
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					chicken.add(new Dot(i, j));
				}
				if (arr[i][j] == 1) {
					house.add(new Dot(i, j));
				}
			}
		}
		temp = new Dot[M];
		combination(0, 0);
		System.out.println(wholeMin);

	}

	private static void combination(int cnt, int start) {
		if (cnt == M) {
			search();
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			temp[cnt] = chicken.get(i);
			combination(cnt + 1, i + 1);
		}
	}

	private static void search() {
		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < temp.length; j++) {
				min = Math.min(min, Math.abs(house.get(i).x - temp[j].x) + Math.abs(house.get(i).y - temp[j].y));
			}
			sum += min;
		}
		wholeMin = Math.min(wholeMin, sum);
	}

	static class Dot { // 2가 있는 지점
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
