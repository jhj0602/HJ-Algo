package ssafy.expert.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class SW11856 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			if(solution(str)==2) {
				
				sb.append("#"+test_case+" "+"Yes\n");
			}else {
				sb.append("#" + test_case +" "+"No\n");
			}
		}
		System.out.println(sb);
	}

	public static int solution(String str) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}

		return set.size();
	}

}
