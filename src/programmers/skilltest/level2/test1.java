package programmers.skilltest.level2;

public class test1 {

	public static void main(String[] args) {
	System.out.println(solution(15));

	}

	public static int solution(int n) {
		int answer = n;
		boolean flag = true;
		int nCount = Integer.bitCount(n);
		while (flag) {
			int nextNumberCount = Integer.bitCount(++answer);
			if(nCount==nextNumberCount) {
				flag=false;
				break;
			}
		}
		return answer;
	}
}
