package programmers.highkit.bruteforce;
public class P42842 {
	public static void main(String[] args) {
		solution(2500, 250);
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int sum = brown + yellow;
		for (int i = 1; i <= sum; i++) {
			if (sum % i == 0) {
				int x = i;
				int y = sum / i;
				if (arrCheck(x, y, brown)) {
					if(x<=y) {
						answer[0] = y;
						answer[1] = x;		
					}
					break;
				}
			}
		}
		return answer;
	}

	public static boolean arrCheck(int x, int y, int brown) {
		int[][] map = new int[x][y];
		int x1 = 0, y1 = 0, x2 = x - 1, y2 = y - 1;
		int brownCnt = 0;
		for (int i = x1; i < x2; i++) {// 아래쪽
			brownCnt++;
		}
		for (int i = y1; i < y2; i++) {// 오른쪽
			brownCnt++;
		}
		for (int i = x2; i > x1; i--) {// 위쪽
			brownCnt++;
		}
		for (int i = y2; i > y1; i--) {// 왼쪽
			brownCnt++;
		}
		return brownCnt == brown? true : false;
	}

}
