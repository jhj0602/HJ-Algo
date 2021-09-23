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
		int[] answer = {};
		String[][] infoTemp = new String[info.length][5];
		String[][] queryTemp = new String[query.length][5];
		for (int i = 0; i < infoTemp.length; i++) {
			String[] str = info[i].split(" ");
			for (int j = 0; j < 5; j++) {
				infoTemp[i][j] = str[j];
			}
		}
		for (int i = 0; i < queryTemp.length; i++) {
			String[] str = query[i].split("and");
			for (int j = 0; j < 5; j++) {
				infoTemp[i][j] = str[j];
			}
		}
		for (int i = 0; i < infoTemp.length; i++) {
			for (int j = 0; j < 5; j++) {
			System.out.print(infoTemp[i][j]+" ");
			}
			System.out.println();
		}
		return answer;
	}

}
