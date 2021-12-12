package programmers.Level2;

import java.util.HashMap;

public class P1835 {

	public static void main(String[] args) {
		P1835 p = new P1835();
		String[] data = { "N~F=0", "R~T>2"};
		p.solution(2, data);
	}

	// 각각 어피치, 콘, 프로도, 제이지, 무지, 네오, 라이언, 튜브
    static int[] position ; // 카카오프렌즈가 서는 위치
    static boolean[] visited ; // 카카오 프렌즈의 방문여부
    static int cnt ;    
    static HashMap<Character, Integer> kakao ;
    static boolean ok ;
    public int solution(int n, String[] data) {
        int answer = 0;
        position = new int[8];
        visited = new boolean[8];
        cnt =0;
        kakao = new HashMap<>();
        ok = true;
        // position의 index번호로 매핑
        kakao.put('A',0);
        kakao.put('C',1);
        kakao.put('F',2);
        kakao.put('J',3);
        kakao.put('M',4);
        kakao.put('N',5);
        kakao.put('R',6);
        kakao.put('T',7);
        
        // 1.순열 
        perm(0, data);
        // 2.조건 검사 
        answer = cnt;
        return answer;
    }
    // 순열
    public static void perm(int idx, String[] data){
        
        // 기저조건 , 8개 순서 다 결정됐다면
        if( idx == 8){
            if ( isOk(data) ){
                cnt ++;
            }                
            return;
        }
        
        // 순열 ㄱㄱ
        for( int i=0; i<8; i++){
            // 사용하지 않은 거라면
            if(!visited[i]){
                visited[i] = true;
                position[idx] = i;
                perm(idx+1, data);
                visited[i] = false;
            } 
            
        }        
    }
    public static boolean isOk( String[] data){
        // 입력 받은 값 꺼내고 검사하자.
        
        
        for( int i=0; i<data.length; i++){
            int X = kakao.get( data[i].charAt(0) );     
            int Y = kakao.get( data[i].charAt(2) );
            char type = data[i].charAt(3);
            int diff = data[i].charAt(4) - '0';
            int Xpos = position[X];
            int Ypos = position[Y];
            if ( type == '='){    
                if ( Math.abs( Xpos - Ypos)-1 != diff){
                    
                    return false;
                }
                
            } else if ( type == '>'){
                if ( Math.abs(Xpos - Ypos )-1 <= diff){
                    
                    return false;
                }
                
                
            } else if ( type == '<') {
                if ( Math.abs(Xpos - Ypos )-1 >= diff){
                    
                    return false;
                }
            }
            
        }
        return true;
    }

}
