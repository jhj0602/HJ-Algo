package programmers.skilltest.level1;

public class test1 {
	public static void main(String[] args) {
	System.out.println(solution("Pyy"));
	}

	static boolean solution(String s) {
		boolean answer = true;
		int pCount = 0;
		int yCount = 0;
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'p') {
				pCount++;
			} else if (s.charAt(i) == 'y') {
				yCount++;
			}
		}

		return pCount == yCount ? true : false;
	}
}
