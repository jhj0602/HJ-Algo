package programmers.level2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class P86971 {
    @Test
    public void 전력망을둘로나누기() throws Exception {
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution(4, wires));
        int [][] wires2 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(9, wires2));
    }

    static int[][] arr;

    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            arr[x][y] = 0;
            arr[y][x] = 0;
            answer = Math.min(answer, bfs(x, n));
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        return answer;
    }

    int bfs(int start, int n) {
        boolean[] visit = new boolean[n + 1];
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int current = q.poll();
            visit[current] = true;
            for (int i = 1; i <= n; i++) {
                if (visit[i]) continue;
                if (arr[current][i] == 1) {
                    q.offer(i);
                    cnt++;
                }
            }
        }
        return Math.abs(cnt - (n - cnt));
    }
}
