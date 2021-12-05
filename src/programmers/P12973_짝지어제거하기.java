package programmers;

public class P12973_짝지어제거하기 {
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
	}

	public static int solution(String s) {
		int answer = -1;

		StringBuffer str = new StringBuffer(s);
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) == str.charAt(i)) {
				str = str.replace(i - 1, i + 1,"");
				i = 0;
			}
		}
		return str.length() == 0 ? 1 : 0;
	}
}
