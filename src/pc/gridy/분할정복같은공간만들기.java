package pc.gridy;

public class 분할정복같은공간만들기 {
	static int white, green;
	static int[][] spaces;

	public static void main(String[] args) {
		int n = 8;
		spaces = new int[][] { { 1, 1, 0, 0, 0, 0, 1, 1 }, { 1, 1, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 0, 0 }, { 1, 0, 0, 0, 1, 1, 1, 1 }, { 0, 1, 0, 0, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1, 1, 1 },

		};
		divide(0, 0, n);
		System.out.println(white);
		System.out.println(green);

	}

	private static void divide(int r, int c, int size) {// 행 열 크기
		int sum = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += spaces[i][j];
			}
		}
		// 같은색인지 체크
		if (sum == size * size) {// 초록색
			green++;
		} else if (sum == 0) {// 하얀색
			white++;
		} else {// 색이 섞여 있음
				// 4분할하여 각각의 사각형 처리
			int half = size / 2;

			divide(r, c, half);// 1사분면 가리키는 매개변수
			divide(r, c + half, half);// 2사분면
			divide(r + half, c, half);// 3사분면
			divide(r + half, c + half, half);// 4사분면
		}
	}
}
