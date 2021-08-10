package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문자	의미
//.	평지(전차가 들어갈 수 있다.)
//*	벽돌로 만들어진 벽
//#	강철로 만들어진 벽
//-	물(전차는 들어갈 수 없다.)
//^	위쪽을 바라보는 전차(아래는 평지이다.)
//v	아래쪽을 바라보는 전차(아래는 평지이다.)
//<	왼쪽을 바라보는 전차(아래는 평지이다.)
//>	오른쪽을 바라보는 전차(아래는 평지이다.)

//문자	동작
//U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
//D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
//L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
//R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
//S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.

public class SW1873 {
	static int H, W;
	static char[][] map;
	static char[] userInput;
	static int x, y, dir;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			x = 0;
			y = 0;
			dir = 0;// 1상 2하 3좌 4우
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
					switch (map[i][j]) {
					case '^':
						dir = 1;
						break;
					case 'v':
						dir = 2;
						break;
					case '<':
						dir = 3;
					case '>':
						dir = 4;

					}

				}
			}
			int userCount = Integer.parseInt(br.readLine());
			userInput = new char[userCount];
			String str = br.readLine();
			userInput = str.toCharArray();

			for (int i = 0; i < userInput.length; i++) {
				int dirIdx = 0;
				switch (userInput[i]) {
				case 'U':
					dir = 1;
					map[x][y] = '^';
					if (x < H-1 && x > 0 && map[x - 1][y] == '.') {
						map[x - 1][y] = map[x][y];
						map[x][y] = '.';
						x-=1;
					}
					break;

				case 'D':
					dir = 2;
					map[x][y] = 'v';
					if (x < H-1 && x > 0 && map[x + 1][y] == '.') {
						map[x + 1][y] = map[x][y];
						map[x][y] = '.';
						x+=1;
					}
					break;
				case 'L':
					dir = 3;
					map[x][y] = '<';
					if (y < W-1 && y > 0 && map[x][y - 1] == '.') {
						map[x][y - 1] = map[x][y];
						map[x][y] = '.';
						y-=1;
					}
					break;
				case 'R':
					dir = 4;
					map[x][y] = '>';
					if (y < W-1 && y > 0 && map[x][y + 1] == '.') {
						map[x][y + 1] = map[x][y];
						map[x][y] = '.';
						y+=1;
					}
					break;

				case 'S':
					switch (dir) {
					case 1:
						dirIdx = x;
						while (true) {
							if (dirIdx - 1<0 || map[dirIdx - 1][y] == '#') {
								break;
							}
							if (map[dirIdx - 1][y] == '*') {
								map[dirIdx - 1][y] = '.';
								break;
							}
							dirIdx-=1;
						}
						break;
					case 2:
						dirIdx = x;
						while (true) {
							if (dirIdx + 1 >=H || map[dirIdx + 1][y] == '#') {
								break;
							}
							if (map[dirIdx + 1][y] == '*') {
								map[dirIdx + 1][y] = '.';
								break;
							}
							dirIdx+=1;
						}
						break;
					case 3:
						dirIdx = y;
						while (true) {
							if (dirIdx - 1 < 0 || map[x][dirIdx - 1] == '#') {
								break;
							}
							if (map[x][dirIdx - 1] == '*') {
								map[x][dirIdx - 1] = '.';
								break;
							}
							dirIdx-=1;
						}
						break;
					case 4:
						dirIdx = y;
						while (true) {
							if (dirIdx + 1 <=W || map[x][dirIdx + 1] == '#') {
								break;
							}
							if (map[x][dirIdx + 1] == '*') {
								map[x][dirIdx + 1] = '.';
								break;
							}
							dirIdx+=1;
						}
						break;

					}
					break;
				}
			}
			
			
			
			sb.append("#"+test_case+" ");
			for(int k=0;k<H;k++) {
				for(int z=0;z<W;z++) {
					sb.append(map[k][z]);
				}
				sb.append("\n");
			}
			

		}
		System.out.println(sb);
	}

}
