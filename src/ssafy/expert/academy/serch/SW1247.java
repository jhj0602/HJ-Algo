package ssafy.expert.academy.serch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SW1247 {
	static int c;
	static int[] customer;
	static ArrayList<Dot> list;
	static ArrayList<Dot> cuslist;
	static Dot[] temp;
	static int minPath;
	static boolean[] flag;//골랐니? 확인 하는거 

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			c = Integer.parseInt(br.readLine());
			customer = new int[c];
			list = new ArrayList<Dot>();// 회사 집
			cuslist = new ArrayList<Dot>();// 고객
			temp = new Dot[c];
			flag = new boolean[c];
			minPath = Integer.MAX_VALUE;
			String[] str = br.readLine().split(" ");
			list.add(new Dot(Integer.parseInt(str[0]), Integer.parseInt(str[1])));// 회사 좌표
			list.add(new Dot(Integer.parseInt(str[2]), Integer.parseInt(str[3])));// 집 좌표
			for (int i = 4; i < str.length; i += 2) {
				cuslist.add(new Dot(Integer.parseInt(str[i]), Integer.parseInt(str[i + 1])));
			}
			permutation(0, 0, list.get(0));// 2부터 고객번호가 들어있음
			sb.append("#" + test_case + " " + minPath + "\n");
		}
		br.close();
		System.out.println(sb);

	}

	private static void permutation(int cnt, int sum, Dot lastPoint) {
		if (cnt == c) {// 고객수
			sum += Math.abs(temp[c - 1].x - list.get(1).x) + Math.abs(temp[c - 1].y - list.get(1).y);// 집이랑 마지막꺼만 해준다
			minPath = Math.min(minPath, sum);
			return;
		}
		for (int i = 0; i < cuslist.size(); i++) {
			if (flag[i]) {
				continue;// 사용중인 수면 다음 수로
			}
			temp[cnt] = cuslist.get(i);
			
			int dist = Math.abs(temp[cnt].x - lastPoint.x) + Math.abs(temp[cnt].y - lastPoint.y);
			if (minPath <= sum + dist) {
				return;
			}else {
				flag[i] = true;
				permutation(cnt + 1, sum + dist, temp[cnt]);
				flag[i] = false;
			}
	
		}
	}

	static class Dot {
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
