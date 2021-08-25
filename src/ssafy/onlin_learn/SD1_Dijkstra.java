package ssafy.onlin_learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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

public class SD1_Dijkstra {

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

		Arrays.fill(distance, INFINITY);// 배열의 값을 MAX_Value로 초기화 시켜준다
		distance[start] = 0; // 시작 정점을 0부터 출발 distance |0 |1 |2 |3 |4 |

//반복문이 되면서 일어나는 배열 변화 과정
//0 1 2 3 4 index(정점번호)
//[false, false, false, false, false]
//[0, 2147483647, 2147483647, 2147483647, 2147483647]
//[true, false, false, false, false]
//[0, 2, 2, 5, 9]
//[true, true, false, false, false]
//[0, 2, 2, 5, 9]
//[true, true, true, false, false]
//[0, 2, 2, 5, 8]
//[true, true, true, true, false]
//[0, 2, 2, 5, 8]
		int min = 0, current = 0;
		for (int i = 0; i < V; ++i) {
//			System.out.println(Arrays.toString(visited));
//			System.out.println(Arrays.toString(distance));
			min = INFINITY;// 최소 거리를 구할 것이기 때문에 MAXVALUE로 초기화 해준다.
			for (int j = 0; j < V; ++j) {
				if (!visited[j] && distance[j] < min) {// 만약 아직 방문하지 않았으면서 거리가 min보다 작을경우
					min = distance[j]; // min에 거리를 넣어준다.
					current = j;// 현재 위치를 j에 해당하는 정점으로 바꾸어 준다.
				}
			}
			visited[current] = true; // 방문한정점 번호를 방문체크해준다.
			if (current == end) { // 만약 현재 정점이 마지막정점 즉 1 2 3 4중에 4에 해당하면 종료시킨다.
				break;
			}

			for (int c = 0; c < V; ++c) {
				if (!visited[c] && matrix[current][c] != 0 && distance[c] > min + matrix[current][c]) {
					// 정점에 방문하지 않았고
					// 인접행렬에 현재 정점 과 반복문에 해당하는 index를 인접행렬에 대입하여 그값이 0이 아니면서
					// 정점거리가 최소거리값 + 가중치 보다 클때
					distance[c] = min + matrix[current][c];
					// 정점 거리를 최소 거리값 + 가중치로 바꾼다
				}
			}
		}
		System.out.println(distance[end]);
	}

}
