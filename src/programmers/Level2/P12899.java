package programmers.level2;

public class P12899 {
    public static void main(String[] args) {
        P12899 p = new P12899();
        System.out.println(p.solution(7));
    }

    public String solution(int n) {
        String answer = "";
        String[] arr = {"4", "1", "2"};
        int num = n;
        while (num > 0) {
            int remainder = num % 3;
            num /= 3;

            if (remainder == 0) num--;

            answer = arr[remainder] + answer;
        }
        return answer;
    }
}
