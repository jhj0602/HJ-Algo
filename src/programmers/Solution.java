package programmers;// 다음과 같이 import를 사용할 수 있습니다.

import java.util.*;

class Solution {
    static class Dot {
        int x;
        int y;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public int solution(int[][] garden) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        Queue<Dot> q = new LinkedList<>();
        int cnt=0;
        int len = garden.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (garden[i][j] == 1) {
                    q.offer(new Dot(i, j));
                    cnt++;
                }
            }
        }
        while (cnt < len * len) {
            Queue<Dot> tempQ = new LinkedList<>();
            answer++;
            for (int k = 0; k < q.size(); k++) {
                Dot dot = q.poll();
                for (int i = 0; i < 4; i++) {
                    int cx = dot.x + dx[i];
                    int cy = dot.y + dy[i];
                    if (cx >= 0 && cy >= 0 && cx < len && cy < len && garden[cx][cy] == 0) {
                        garden[cx][cy] = 1;
                        cnt++;
                        tempQ.offer(new Dot(cx, cy));
                    }
                }
            }
            q =tempQ;
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(garden1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(garden2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

    }
}