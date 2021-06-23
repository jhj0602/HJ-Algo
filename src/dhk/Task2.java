package dhk;

class Solution2 {
	public String solution(String S) {
		String file = "";
		int answer = 255;
		String user = "root";
		String[] extension = { "doc", "xls", "pdf" };
		for (String tmp : S.split("\n")) {
			String[] data = tmp.trim().split(" ");
			String fileExt = data[2].substring(data[2].lastIndexOf(".") + 1).toLowerCase();
			for (String ext : extension) {
				if (fileExt.equals(ext)) {
					if (data[0].equals(user) && data[1].startsWith("r-")) {
						if (answer > data[2].length()) {
							file = data[2];
							answer = file.length();
						}
					}
					break;
				}
			}
		}
		if (answer < 255)
			return String.valueOf(answer);
		else
			return "NO FILES";
	}
}

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 s = new Solution2();
		String S = "  root r-x delete-this.xls\n  root r-- bug-report.pdf\n  root r-- doc.xls\n  root r-- podcast.flac\n alice r-- system.xls\n  root --x invoices.pdf\n admin rwx SETUP.PY";
		System.out.println(s.solution(S));

	}

}
