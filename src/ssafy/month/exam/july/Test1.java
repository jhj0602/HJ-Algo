package ssafy.month.exam.july;
public class Test1 {

	public static void main(String[] args) {
		int cnt = 0;
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(++cnt + " ");
			}
			System.out.println("");
		}
		char[] arr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z' ,' ',' ',' ',' ',' ',' ',' ',' '};

		System.out.println();
		char cnt2 = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {

				System.out.print(arr[cnt2] + " ");
				if(arr[cnt2]=='Z') {
					System.exit(0);
				}
				cnt2++;
				

			}
			System.out.println("");
		}

	}

}
