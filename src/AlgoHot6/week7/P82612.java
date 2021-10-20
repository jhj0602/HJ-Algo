package AlgoHot6.week7;

//부족한 금액 계산하기
public class P82612 {

	public static void main(String[] args) {
		solution(3, 20, 4);

	}

	public static long solution(int price, int money, int count) {
		long answer = -1;
		long sum = 0;
		for (int i = 1; i <=count; i++) {
			sum+=i*price;
		}
		answer =  sum-money;
		System.out.println(answer);
		return answer>0?answer:0;
	}
}
