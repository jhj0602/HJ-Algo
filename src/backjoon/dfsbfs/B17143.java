package backjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B17143 {
	static int R, C;
	static int[][] map;
	static ArrayList<Shark> shark = new ArrayList<Shark>();
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };
	static HashMap<Integer, Shark> sharkMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];
		sharkMap = new HashMap<Integer, Shark>();
		for (int i = 0; i < S; i++) {
			String[] str = br.readLine().split(" ");
			map[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = Integer.parseInt(str[4]);
			sharkMap.put(Integer.parseInt(str[4]), new Shark(Integer.parseInt(str[0]), Integer.parseInt(str[1]),
					Integer.parseInt(str[2]), Integer.parseInt(str[3])));
		}
		int catchSize = 0;
		int king = 1;
		while (king <= C) {
			for (int i = 1; i <= R; i++) {
				if (map[i][king] != 0) {
					catchSize += map[i][king];
					sharkMap.remove(map[i][king]);
					map[i][king]=0;
					break;
				}
			}
			sharkReset();
			king++;
		}
		System.out.println(catchSize);
	}

	private static void sharkReset() {
		map = new int[R + 1][C + 1];
		ArrayList<Integer> list = new ArrayList<>();
		for (int s : sharkMap.keySet()) {
			sharkMove(s);
			Shark shark = sharkMap.get(s);
			int r = shark.r;
			int c = shark.c;
			if (map[r][c] == 0) {
				map[r][c] = s;
			} else {
				if (map[r][c] < s) {
					list.add(map[r][c]);
					map[r][c] = s;
				}else {
					list.add(s);
				}
			}
		}
		for (int i : list) {
			sharkMap.remove(i);
		}
		
	}

	private static void sharkMove(int key) {
		Shark shark = sharkMap.get(key);
		int r = shark.r;
		int c = shark.c;
		int d = shark.d;
		int speed = shark.s;
		while (speed > 0) {
			r += dx[d];
			c += dy[d];
			if (r < 1 || r >= R+1 || c < 1 || c >= C+1) {
				if(d%2==0) {
					d-=1;
				}else {
					d+=1;
				}
				r += dx[d]*2;
				c += dy[d]*2;
			}

			speed--;
		}
		sharkMap.put(key, new Shark(r, c, shark.s, d));
	}

	static class Shark {
		int r;
		int c;
		int s;// 스피드
		int d;// 방향

		public Shark(int r, int c, int s, int d) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;

		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + "]";
		}
	}

}