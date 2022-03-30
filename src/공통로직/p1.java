package 공통로직;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class p1 {
    public static void main(String[] args) {
        String Data = "www.ssafe.kr/?name=형준,age=27";
        System.out.println("초기값 : "+Data);

        String encodeData = "";
        String decodeData = "";

        //==== url 인코딩 수행 실시 ====
        try {
            encodeData = URLEncoder.encode(Data, "UTF-8");
            System.out.println("인코딩된 URL  : "+encodeData);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        //==== url 디코딩 수행 실시 ====
        try {
            decodeData = URLDecoder.decode(encodeData, "UTF-8");
            System.out.println("URL 디코딩 : "+decodeData);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
