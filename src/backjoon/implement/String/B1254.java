package backjoon.implement.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1254 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int min = 100;
        int len = str.length();
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, len);
            if (palindrome(temp)) {
                min = Math.min(min, str.length() + i);
            }
        }
        System.out.println(min);
    }

    private static boolean palindrome(String temp) {
        for (int i = 0; i < temp.length() / 2; i++) {
            if(temp.charAt(i) != temp.charAt(temp.length()-1-i))
                return false;
        }
        return true;
    }
}
