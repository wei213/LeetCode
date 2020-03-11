package problems.dynamicProgramming;
import java.util.*;
public class HouseRobber {
	/**
	 * @problem leetcode HouseRobber
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			if(n == 0) {
				System.out.println("n equal to zero");
				return;
			}
			int rob = 0, notRob = 0;
			for(int i=0; i<n; i++) {
				if(i == 0) {
					rob = nums[i];
					notRob = 0;
				}else {
					int temp = notRob;
					notRob = Math.max(notRob, rob);
					rob = nums[i] + temp;
				}
			}
			System.out.println(Math.max(rob, notRob));
		}
	}
}
