package programmers.highkit.dfsbfs;

public class 타켓넘버 {

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		solution(numbers, target);

	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		int temp = sum;
		for (int i = 0; i < numbers.length; i++) {
			temp = numbers[i];
			for (int j = 0; j < numbers.length; j++) {
				if (i == j)
					continue;
				if (temp > target) {
					temp -= numbers[j];
				} else if (temp < target) {
					temp += numbers[j];
				}else {
					answer++;
				}
			}
		}
		System.out.println(answer);
		return answer;
	}

}
