package programmers.level2;

import org.junit.Test;

import java.util.Arrays;

public class P42885 {
    @Test
    public void 정답() {
        int[] people = {70, 50, 80, 50};
        System.out.println(solution(people, 100));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        for (int i = 0; i < people.length; i++) {
            int sum=0;
            for(int j=i;j<people.length;j++){
                if(sum+people[j]<=limit){
                    sum+=people[j];
                    continue;
                }
                i=j;
                break;
            }
            answer++;

        }
        return answer;
    }
}
