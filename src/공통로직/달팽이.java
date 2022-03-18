package 공통로직;

public class 달팽이 {
    public int solution(int n) {
        int count = 1;
        int input = n;
        int right = 0;
        int bottom = -1;
        int top = 1;
        int[][] arr = new int[n][n];
        for (int i = input; i >=0 ; i--) {
            for (int j = 0; j < input; j++) {
                bottom+=top;
                arr[right][bottom] = count;
                count++;
            }
            input--;
            for (int j = 0; j < input; j++) {
                right+=top;
                arr[right][bottom] = count;
                count++;
            }
            top*=-1;

        }

        int answer = 0;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            answer += arr[x][y];
            x += 1;
            y += 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        달팽이 sol = new 달팽이();
        int n1 = 3;
        int ret1 = sol.solution(n1);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 2;
        int ret2 = sol.solution(n2);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}

