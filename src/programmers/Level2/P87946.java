package programmers.level2;

import org.junit.Test;

public class P87946 {
    @Test
    public void 정답(){
        int[][]dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(80,dungeons));
    }
    static int max =0;
    static boolean [] isSelect;
    static int [] temp;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int len = dungeons.length;
        isSelect= new boolean[len];
        temp=new int [len];
        permutaion(0,dungeons,len,k);
        answer=max;
        return answer;
    }
    public void permutaion(int cnt,int [][] dungeons,int len,int k){
        if(cnt==len){
            int result =0;
            int tempK = k;
            for(int i=0;i<len;i++){
                if(dungeons[temp[i]][0]>tempK)break;
                result++;
                tempK-=dungeons[temp[i]][1];
            }
            max = Math.max(result,max);
            return;
        }
        for(int i=0;i<len;i++){
            if(isSelect[i])continue;
            temp[cnt]=i;
            isSelect[i] = true;
            permutaion(cnt+1,dungeons,len,k);
            isSelect[i] = false;
        }
    }
}
