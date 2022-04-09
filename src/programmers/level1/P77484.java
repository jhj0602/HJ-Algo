package programmers.level1;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class P77484 {
    @Test
    public void 정답(){
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos,win_nums)));

    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer =new int [2];
        int point = 0;
        int zero=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank=0;
        for(int i=6;i>1;i--){
            map.put(i,++rank);
        }
        for(int i : lottos){
            if(i==0){
                zero++;
                continue;
            }
            for(int j=0;j<6;j++){
                if(i==win_nums[j]){
                    point++;
                    break;
                }
            }
        }
        answer[0] = map.containsKey(point+zero)? map.get(point+zero):6;
        answer[1] = map.containsKey(point)? map.get(point):6;
        return answer;
    }
}
