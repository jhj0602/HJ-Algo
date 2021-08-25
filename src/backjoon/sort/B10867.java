package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class B10867 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			set.add(Integer.parseInt(arr[i]));
		}
		Integer[] arr2 = new Integer[set.size()];
		set.toArray(arr2);
		Arrays.sort(arr2);
		for(int i=0;i<arr2.length;i++) {
			
			System.out.print(arr2[i]+" ");
		}

	}

}
