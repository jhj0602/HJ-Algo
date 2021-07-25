package naver_live;

public class CallbyValueCallbyReference {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 4, 2, 6 };
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		test(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	private static void test(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] *= 10;
		}

	}

}
