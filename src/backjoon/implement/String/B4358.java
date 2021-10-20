package backjoon.implement.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B4358 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		TreeMap<String, Double> map = new TreeMap<String, Double>();
		String str = br.readLine();
		double count=0;
		 while (scan.hasNextLine()) {
	            String input = scan.nextLine();
	            // 처음 들어있는 값인 경우
	            if (map.get(input) == null) {
	                map.put(input, 1.0);
	                tree.add(input);
	            } 
	            // 기존에 존재할경우 갯수 증가
	            else {
	                map.put(input, map.get(input) + 1.0);
	            }
	            
	            totalCnt++;
	        }


		for (String s : map.keySet()) {
			double v = map.get(s);
			double d= (double)(  v* 100.0) / count;
			sb.append(s + " " + String.format("%.4f", d) + "\n");
		}
		System.out.println(sb);

	}

}
