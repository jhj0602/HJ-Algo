package ssafy.month.exam.july;
public class Test4 {
	public static void main(String[] args) {
		System.out.println("test4");
		StringBuilder sb = new StringBuilder();
		int inserPrice = 10000;
		int productPrice = 2530;
		int r = inserPrice - productPrice;
		int[] arr = { 1000, 500, 100, 50, 10 };
		sb.append("투입금액:"+inserPrice+"\n");
		sb.append("상품금액:"+productPrice+"\n");
		sb.append("거스름돈:"+r+"\n");
		sb.append("------------------------\n");
		for (int i = 0; i < arr.length; i++) {
			int temp = r / arr[i];
			r -= (arr[i] * temp);
			sb.append(arr[i] + "원:" + temp + "장\n");

		}
		System.out.println(sb);
	}
}