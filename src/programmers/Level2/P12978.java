package programmers.level2;

import org.junit.Test;

import java.util.Arrays;

public class P12978 {
    @Test
    public void 정답() {
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        System.out.println(solution(5, road, 3));
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int start = 1;
        int end = N;

        int[][] map = new int[N + 1][N + 1];
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = 500001;
            }
        }
        for (int i = 0; i < road.length; ++i) {
            map[road[i][0]][road[i][1]] = road[i][2];
            map[road[i][1]][road[i][0]] = road[i][2];
        }
        Arrays.fill(distance, 50001);
        distance[start] = 0;

        int min = 0, current = 1;
        for (int i = 1; i <= N; i++) {
            min = 50001;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }
            visited[current] = true;
            if (current == end) {
                break;
            }
            for (int c = 1; c <= N; c++) {
                if (!visited[c] && map[current][c] != 0
                        && distance[c] > min + map[current][c]) {
                    distance[c] = min + map[current][c];
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        for (int i : distance) {
            if (i <= K) answer++;
        }
        return answer;
    }
}
