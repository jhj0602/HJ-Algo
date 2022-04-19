package DEVMATCHING;

import org.junit.Test;

import java.util.ArrayList;

public class p2 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Dot> list;
    static Dot[] temp;

    @Test
    public void 정답() throws Exception {
        String[] grid = {"??b", "abc", "cc?"};
        solution(grid);

    }

    public int solution(String[] grid) {
        int answer = -1;
        ArrayList<Dot> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '?') {
                    System.out.println(i + " " + j);
                    list.add(new Dot(i, j));
                }
            }
        }
        temp = new Dot[list.size()];
        dfs(grid, 0);
        return answer;
    }

    public void dfs(String[] grid, int cnt) {
        if (cnt == list.size()) {
            for (Dot d : temp) {
                System.out.println(d.x + " " + d.y);
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            temp[cnt] = list.get(i);
            dfs(grid, cnt + 1);
        }
    }


    static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
