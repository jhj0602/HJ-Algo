package ssafy.month.exam.july;
import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {

		System.out.println("test2");

		int[] su = { 34, 55, 27, 67, 45, 82, 68, 99, 77, 18 };
		float sum = 0;
		for (int i : su) {
			sum += i;
		}
		double avg = sum / su.length;

		int[] temp = new int[su.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = Math.abs(Math.abs((int) (avg - (double) su[i])));
		}
		Arrays.sort(temp);
		int min=0;
		for (int i = 0; i < temp.length; i++) {
			if(Math.abs((int) (avg - (double) su[i]))==temp[0]){
				min = su[i];
			}
		}
		System.out.println(sum / su.length+" "+min);

	}
}
