//Level2 타켓넘버 재귀
package programmers.Level2;

public class P43165 {
	static int answer = 0;

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		solution(numbers, 3);
	}

	public static int solution(int[] numbers, int target) {
		dfs(0, 0, target, numbers);
		return answer;
	}

	private static void dfs(int cnt, int sum, int target, int[] numbers) {
		if (cnt == numbers.length) {
			if (sum == target)
				answer++;
			return;
		}
		sum += numbers[cnt];
		dfs(cnt + 1, sum, target, numbers);
		sum -= numbers[cnt];
		sum += (numbers[cnt] * -1);
		dfs(cnt + 1, sum, target, numbers);
	}
}
