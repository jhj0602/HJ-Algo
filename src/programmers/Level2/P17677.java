// Level2 뉴스 클러스터링
package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P17677 {

	public static void main(String[] args) {
		P17677 p = new P17677();
		p.solution("aa1+aa2", "AAAA12");

	}

	public int solution(String str1, String str2) {
		int answer = 0;
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		ArrayList<String> firstList = new ArrayList<>();
		for (int i = 1; i < str1.length(); i++) {
			char c1= str1.charAt(i - 1);
			char c2 =str1.charAt(i);
			if(Character.isAlphabetic(c1)&&Character.isAlphabetic(c2)) {
				firstList.add(c1+""+c2);
			}
			
		}
		Collections.sort(firstList);
		System.out.println(firstList);
		List<String> secondList = new ArrayList<>();
		for (int i = 1; i < str2.length(); i++) {
			char c1= str2.charAt(i - 1);
			char c2 =str2.charAt(i);
			if(Character.isAlphabetic(c1)&&Character.isAlphabetic(c2)) {
				secondList.add(c1+""+c2);
			}
		}
		Collections.sort(secondList);
		System.out.println(secondList);
		return answer;
	}

}
