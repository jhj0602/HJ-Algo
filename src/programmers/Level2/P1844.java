package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class P1844 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        P1844 p = new P1844();
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(p.solution(maps));
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(p.solution(maps2));
    }

    public int solution(int[][] maps) {
        int answer = 0;
        Queue<Dot> q = new LinkedList<>();
        q.offer(new Dot(0, 0));
        int col = maps.length;
        int row = maps[0].length;
        int[][] dist = new int[col][row];
        dist[0][0] = 1;
        maps[0][0] = 0;
        while (!q.isEmpty()) {
            Dot dot = q.poll();
            for (int i = 0; i < 4; i++) {
                int cx = dot.x + dx[i];
                int cy = dot.y + dy[i];
                if (cx >= 0 && cx < col && cy >= 0 && cy < row
                        && maps[cx][cy] == 1) {
                    maps[cx][cy] = 0;
                    q.offer(new Dot(cx, cy));
                    dist[cx][cy] = dist[dot.x][dot.y] + 1;
                }
            }
        }
        answer = dist[col - 1][row - 1];
        return answer == 0 ? -1 : answer;
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
