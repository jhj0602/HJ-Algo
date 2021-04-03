package kakao_makers;

class Solution2 {
	static int answer = 0;
	static int[] need;
	static boolean[] visited;

	public int solution(int[][] needs, int r) {
		need = new int[needs.length];
		visited = new boolean[needs[0].length];
		for (int i = 0; i < needs.length; i++) {
			int vertax = 1;
			for (int j = 0; j < needs[i].length; j++, vertax *= 2) {
				need[i] += vertax * needs[i][j];
			}
		}
		solve(0, needs[0].length, r, needs.length);
		return answer;
	}

	static void solve(int start, int n, int r, int sz) {
		if (r == 0) {
			int temp = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					temp += (1 << i);
				}
			}
			
			int res = 0;
			for (int i = 0; i < sz; i++) {
				if ((need[i] & temp) == need[i])
					res++;
			}
			answer = answer > res ? answer : res;
			return;
		} else {
			for (int i = start; i < n; i++) {
				visited[i] = true;
				solve(i + 1, n, r - 1, sz);
				visited[i] = false;
			}
		}

	}

}