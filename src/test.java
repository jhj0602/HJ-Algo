import java.util.Scanner;

public class test {

	static int[] price;
	static int[] like;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		
		price = new int[] {1500,300,1000,450,800,500,900,2550,600};
		like = new int[9];
		
		for(int i = 0; i < 9; i++) {
			like[i] = sc.nextInt();
		}
		
		int[][] dp = new int[9][money + 1];
		
		//초기화
		for(int j = 0; j <= money; j++) {
			if(j - price[0] >= 0 && dp[0][j] < dp[0][j - price[0]] + like[0]) {
				dp[0][j] = dp[0][j - price[0]] + like[0];
			}
		}
		
		for(int i = 1; i < 9; i++) {
			for(int j = 1; j <= money; j++) {
				dp[i][j] = dp[i - 1][j - 1];
				if(j - price[i] >= 0 && dp[i][j] < dp[i][j - price[i]] + like[i]) {
					dp[i][j] = dp[i][j - price[i]] + like[i];
					
					
				}else {
					System.out.print(like[i]+" "+price[i]+" ");
				}
				
			}
			System.out.println();
		}
		
		System.out.println(dp[8][money]);
		
	}


}
