package 공통로직;

public class 소수알고리즘 {
    public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPrime(80));
        System.out.println(isPrime(79));
    }
}
