package AlgoHot6.week7;

import java.util.ArrayList;
import java.util.HashSet;

public class P42890 {
	static int N;
	static String[][] temp;

	public static void main(String[] args) {
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		System.out.println(solution(relation));
	}

	public static int solution(String[][] relation) {
		int answer = 0;
		N = relation[0].length;// 속성 갯수
		arr = new int[N];
		isSelected = new boolean[N];
		temp = relation;
		for (int i = 0; i < N; i++) {//1~n개 까지 조합 뽑기
			comb(0, 0, i + 1);
		}
		return candi.size();
	}

	static int[] arr;
	static boolean[] isSelected;
	static ArrayList<String> candi = new ArrayList<>();

	public static void comb(int idx, int cnt, int size) {
		if (cnt == size) {// 하나의 부분집합이 완성 됐을 때 할일.
			ArrayList<Integer> list = new ArrayList<>();
			String key = "";
			for (int i = 0; i < size; i++) {
				if (isSelected[i])
					key += i;
				list.add(i);
			}
			
			HashSet<String> set = new HashSet<>();
			for (int i = 0; i < temp.length; i++) {
				String s = "";
				for (Integer j : list) {
					s += temp[i][j];
				}
				if (set.contains(s)) {//키가 있으면 얜 안댐
					return;
				} else {
					set.add(s);
				}
			}
			System.out.println(set);
			// 후보키 추가
			for (String s : candi) {
				int count = 0;
				for (int i = 0; i < key.length(); i++) {
					String subS = String.valueOf(key.charAt(i));
					if (s.contains(subS))
						count++;
				}
				if (count == s.length())
					return;
			}
			// 어떠한 부분집합으로라도 없다면 최소성 통과  하고 추가해준다.
			candi.add(key);

			return;
		}

		for (int i = cnt; i < N; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			comb(cnt + 1, cnt + 1, size);
			isSelected[i] = false;
		}

	}

}
