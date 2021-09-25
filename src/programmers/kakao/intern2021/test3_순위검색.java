package programmers.kakao.intern2021;

public class test3_순위검색 {

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		solution(info, query);
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int [query.length];
		String[][] infoTemp = new String[info.length][5];
		String[][] queryTemp = new String[query.length][4];
		for (int i = 0; i < infoTemp.length; i++) {
			String[] str = info[i].split(" ");
			for (int j = 0; j < 5; j++) {
				infoTemp[i][j] = str[j];
			}
		}
		for (int i = 0; i < queryTemp.length; i++) {
			String[] str = query[i].split("and");
			for (int j = 0; j < 4; j++) {
				queryTemp[i][j] = str[j].trim();
			}
		}
		for (int i = 0; i < infoTemp.length; i++) {
			for (int j = 0; j < infoTemp[0].length; j++) {
				System.out.print(infoTemp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < queryTemp.length; i++) {
			for (int j = 0; j < queryTemp[0].length; j++) {
				System.out.print(queryTemp[i][j].trim() + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < queryTemp.length; i++) {
			int cnt = 0;

			answer[i] = cnt;
		}

		return answer;
	}

}
