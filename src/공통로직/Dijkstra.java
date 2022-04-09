package 공통로직;
/*
최단 경로 알고리즘
 하나의 시작 정점에서 끝 정점까지의 최단경로 #다익스트라 #밸만포드
 간선의 가중치가 있는 그래프에서 두 정점 사이의 경로들 중에 간선의 가중치의 합이 최소인 경로
 음의 가중치를 허용하지 않음
 최단이라는 단어가 나온다면 가중치가 있냐 없냐를 보자
 가중치가 없다면 BFS로 푼다
 가중치가 있다면 다해보는 시도를 해야한다.
 가중치가 음수로 나온다 밸만 포드를 쓰자
 다익스트라는 음수의 가중치를 허용하지 않는다.


 모든 정점들에 대한 최단경로
 플로이드 와샬 알고리즘을 쓴다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 다익스트라 : 시작 정점에서의 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식
//             탐욕 기법을 사용한 알고리즘으로 MST의 프림 알고리즘과 유사하다.
public class Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        int V = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = V - 1;
        final int INFINITY = Integer.MAX_VALUE;

        int[][] matrix = new int[V][V];
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; ++i) {
            st = new StringTokenizer(in.readLine().trim(), " ");
            for (int j = 0; j < V; ++j) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(distance, INFINITY);
        distance[start] = 0;

        int min = 0, current = 0;
        for (int i = 0; i < V; ++i) {

            min = INFINITY;
            for (int j = 0; j < V; ++j) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }
            visited[current] = true;
            if (current == end) {
                break;
            }

            for (int c = 0; c < V; ++c) {
                if (!visited[c] && matrix[current][c] != 0
                        && distance[c] > min + matrix[current][c]) {
                    distance[c] = min + matrix[current][c];
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println(distance[end]);
    }
}
/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

==> 8

4
0 94 53 16
79 0 24 18
91 80 0 98
26 51 92 0
==> 16


7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0

==> 14
 */