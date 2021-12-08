//완전탐색/소수찾기
package programmers;

import java.util.HashSet;

public class P42839 {
	static char[] numberArr = {};
	static char[] temp;
	static boolean[] visit;
	static int count;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		System.out.println(solution("17"));
	}

	public static int solution(String numbers) {
		numberArr = numbers.toCharArray();
		temp = new char[numbers.length()];
		visit = new boolean[numbers.length()];
		combination(0, "");
		return set.size();
	}

	public static void combination(int cnt, String str) {
		if (str != "") {
			int num = Integer.parseInt(str);
			if (isPrime(num)) {
				set.add(num);
			}
		}

		if (cnt == numberArr.length) {
			return;
		}

		for (int i = 0; i < numberArr.length; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			combination(cnt + 1, str + numberArr[i]);
			visit[i] = false;
		}
	}

    public static boolean isPrime(int num){ //소수 판별
        if(num==1||num==0) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        
        return true;
    }
}
