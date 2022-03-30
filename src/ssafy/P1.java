package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1 {
    static int N = 0;
    static int[][] map;
    static HashMap<Integer, Dot> mcDot;
    static ArrayList<Integer> monsterList;
    static int[] killOrder;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            mcDot = new HashMap<>();
            monsterList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num != 0) {
                        mcDot.put(num, new Dot(i, j));
                        if (num > 0) {
                            monsterList.add(num);
                        }
                    }
                }
            }
            killOrder = new int[monsterList.size()];
            isSelected = new boolean[monsterList.size()];
            System.out.println("조합");
            perm(0, 0);
//            for (int i : mcDot.keySet()) {
//                System.out.println(i + " " + mcDot.get(i).x + " " + mcDot.get(i).y);
//            }
        }

    }

    private static void perm(int cnt, int start) {
        if (cnt == monsterList.size()) {
            System.out.println(Arrays.toString(killOrder));
            return;
        }
        for (int i = start; i < monsterList.size(); i++) {
            if (isSelected[i])
                continue;// 사용중인 수면 다음 수로
            killOrder[cnt] = monsterList.get(i);
            isSelected[i] = true;
            perm(cnt + 1, start);
            isSelected[i] = false;
        }
    }
    //몬스터로 가는 최단거리

    //몬스터에서 고객으로 가는 최단거리

    static class Dot {
        int x;
        int y;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
//        2
//        3
//        0 0 0
//        0 1 -1
//        0 0 0
//        4
//        -3 -1 1 0
//        -2 0 0 3
//        0 0 0 0
//        0 0 2 0