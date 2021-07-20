package naver_live;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TestHashMapSort {

	public static void main(String[] args) throws IOException {
		int[] a = { 4, 5, 6, 5, 4, 3 };
		solution(a);
	}

	public static void solution(int[] input) {
		StringBuilder sb = new StringBuilder();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(Integer i : input) {
			map.put(i,map.getOrDefault(i,0)+1);
			
		}
		sb.append(map+"\n");
		List<Integer> list = sortByValue(map);
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<map.get(list.get(i));j++) {
				sb.append(list.get(i)+" ");
			}
		}
		
		System.out.println(sb);
		
	}

	public static List<Integer> sortByValue(HashMap<Integer, Integer> map) {
		List<Integer> list = new ArrayList<>();
		list.addAll(map.keySet());
		Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
            	Integer v1 = map.get(o1);
            	Integer v2 = map.get(o2);

            	return v2 - v1;
            }
        });
		return list;
	}

}
