package programmers.level1;

import org.junit.Test;

public class P12947 {
    @Test
    public void 하샤드수() throws Exception {

        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }
    public boolean solution(int x) {
        int num = x;
        int sum =0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return x%sum==0?true:false;
    }
}
