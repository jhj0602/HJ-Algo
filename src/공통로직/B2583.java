package 공통로직;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2583 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            String[] str = br.readLine().split(" ");
            squareDraw(str);
        }

    }

     static void squareDraw(String[] str) {
        int[] area = new int[str.length];
        for (int i = 0; i < area.length; i++) {
            area[i] = Integer.parseInt(str[i]);
        }
    }
}
