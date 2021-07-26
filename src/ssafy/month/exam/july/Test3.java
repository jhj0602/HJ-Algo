package ssafy.month.exam.july;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Test3 {

	public void execute(String msg) {
		HashMap<Character, Integer> map = new HashMap<>();
		int tempsize = 1;
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < msg.length(); i++) {

			map.put(msg.charAt(i), map.getOrDefault(msg.charAt(i), 0) + 1);
			if (map.size() == tempsize) {
				list.add(msg.charAt(i));
				tempsize++;
			}
		}
		int cnt =0;
		Collections.sort(list);
		for (int i : map.values()) {
			System.out.println(list.get(cnt)+" : "+i);
			cnt++;

		}

	}

	public static void main(String[] args) {
		Test3 c = new Test3();
		c.execute("5329053995535987827332679340558347453272569584");
		System.out.println("---");
		c.execute("122333444455555666666");
		System.out.println("test3");
	}
}
