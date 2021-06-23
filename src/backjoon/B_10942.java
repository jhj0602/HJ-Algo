package backjoon;

import java.io.IOException;

public class B_10942 {

	public static void main(String[] args) throws IOException {
		int[][] maps = { { 1, 28, 41, 22, 25, 79, 4 }, { 39, 20, 10, 17, 19, 18, 8 }, { 21, 4, 13, 12, 9, 29, 19 },
				{ 58, 1, 20, 5, 8, 16, 9 }, { 5, 6, 15, 2, 39, 8, 29 }, { 39, 7, 17, 5, 4, 49, 5 },
				{ 74, 46, 8, 11, 25, 2, 11 } };
		int p = 19;
		int r = 6;
		System.out.println(solution(maps, p, r));
	}

	public static int solution(int[][] maps, int p, int r) {
		int answer = 0;
		for (int i = 0; i <= maps.length; i++) {
			for (int j = 0; j <= maps.length; j++) {
				int tmp = 0;
				int cnt = 1;
				for (int x = Math.max(0, i - r / 2); x < i; x++, cnt++) {
					for (int y = Math.max(0, j - cnt); y <= Math.min(maps.length, j + cnt); y++) {
						if(maps[x][y] <= p)
							tmp++;
					}
				}
				System.out.println("±³Â÷");
				for (int x = i; x <= Math.min(maps.length, i + r / 2); x++, cnt--) {
					for (int y = Math.max(0, j - cnt); y <= Math.min(maps.length, j + cnt); y++) {
						if(maps[x][y] <= p)
							tmp++;
					}
				}
				System.out.println();
			}
		}

		return answer;
	}

}

//public static int[] solution(String code, String day, String[] data) {
//	int cnt = 0;
//    TreeMap<Integer,Integer> hm = new TreeMap<Integer,Integer>();
//    for(int i = 0; i < data.length; i++) {
//    	String t[] = data[i].split(" ");
//    	if(t[1].endsWith(code)) {
//    		if(t[2].substring(5,13).equals(day)) {
//    			hm.put(Integer.parseInt(t[2].substring(13)),Integer.parseInt(t[0].substring(6)));
//    			cnt++;
//    		};
//    	}
//    }
//    int[] answer = new int[cnt];
//    cnt = 0;
//    for(Integer i :hm.keySet()) {
//    	answer[cnt++] = hm.get(i);
//    }
//    return answer;
//}

//class Person {
//	int id;
//	int time;
//	int grade;
//
//	public Person(int id, int time, int grade) {
//		this.id = id;
//		this.time = time;
//		this.grade = grade;
//	}
//}
//public static int[] solution(int[] t, int[] r) {
//	int[] answer = new int[t.length];
//	ArrayList<Person> ps = new ArrayList<Person>();
//	for (int i = 0; i < t.length; i++) {
//		ps.add(new Person(i, t[i], r[i]));
//	}
//	Collections.sort(ps, new Comparator<Person>() {
//		@Override
//		public int compare(Person p1, Person p2) {
//			if (p1.time < p2.time) {
//				return -1;
//			} else if (p1.time == p2.time) {
//				if (p1.id < p2.id) {
//					return -1;
//				} else
//					return 1;
//			}
//			return 1;
//		}
//	});
//	PriorityQueue<Person> pq = new PriorityQueue<Person>(new Comparator<Person>() {
//		@Override
//		public int compare(Person p1, Person p2) {
//			if (p1.grade < p2.grade) {
//				return -1;
//			} else if (p1.grade == p2.grade) {
//				if (p1.time < p2.time) {
//					return -1;
//				} else if (p1.time == p2.time) {
//					return p1.id < p2.id ? -1 : 1;
//				} else
//					return 1;
//			} else
//				return 1;
//		};
//	});
//	int time = ps.get(0).time;
//	int i = 0;
//	int c = 0;
//	while (i < t.length && time >= ps.get(i).time) {
//		pq.add(ps.get(i));
//		i++;
//	}
//	while (i < t.length) {
//		while (pq.size() > 0 && time >= pq.peek().time) {
//			Person x = pq.poll();
//			answer[c++] = x.id;
//			time++;
//			while (i < t.length && time >= ps.get(i).time) {
//				pq.add(ps.get(i));
//				i++;
//			}
//		}
//		if (pq.size() == 0 && i < t.length) {
//			time = ps.get(i).time;
//			while (i < t.length && time >= ps.get(i).time) {
//				pq.add(ps.get(i));
//				i++;
//			}
//		}
//	}
//
//	return answer;
//}