package 공통로직;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS {
    static int N;//정점 개수
    static boolean[][] adjMatrix; //인접행렬


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjMatrix = new boolean[N][N];
        int C = Integer.parseInt(br.readLine());//간선 갯수
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[to][from] = adjMatrix[from][to] = true; //무향 그래프
        }
        bfs();
        System.out.println("===================");
        boolean[] visited = new boolean[N];//방문 시작점 고려하기
        dfs(0, visited);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.print(current+" ");
            for (int i = 0; i < N; i++) {
                if (!visited[i] && adjMatrix[current][i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfs(int current, boolean[] visited) {//현재 탐색정점이 어딘지
        visited[current] = true;
        System.out.print(current+" ");
        for (int i = 0; i < N; i++) {
            if (!visited[i] && adjMatrix[current][i]) {
                visited[i] = true;
                dfs(i, visited);
            }
        }
    }

}
//7
//8
//0 1
//0 2
//1 3
//1 4
//2 4
//3 5
//4 5
//5 6