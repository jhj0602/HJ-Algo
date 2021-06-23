package dhk;

class Solution3 {
	public int solution(int N) {
		// write your code in Java SE 8
		boolean find;
		int answer;
		for(int i = N+1;;i++) {
			String tmp = String.valueOf(i);
			char n = tmp.charAt(0);
			find = true;
			answer = i;
			for(int j = 1; j < tmp.length(); j++) {
				if(n==tmp.charAt(j)) {
					find = false;
					break;
				}
				n = tmp.charAt(j);
			}
			if(find)
				break;
		}
		return answer;
	}
}

public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 s = new Solution3();
		int N = 87654321;
		System.out.println(s.solution(N));

	}

}
