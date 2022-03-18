package backjoon.exhaustive_search.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String temp = str;
        int palindromeLength =0;
        for (int i = str.length()-2; i >=0; i--) {
            if(palindrome(temp)){
                System.out.println(temp.length());
                palindromeLength = temp.length();
                break;
            }
            temp +=String.valueOf(str.charAt(i));
        }
        System.out.println(palindromeLength);
    }
    static boolean palindrome(String s){
        int j= s.length()-1;
        for (int i = 0; i <s.length()/2-1 ; i++) {
            if (s.charAt(i)==s.charAt(j)){
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
