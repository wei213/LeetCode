package problems.slidingWindow;
import java.util.*;
public class MinimumSizeSubarraySum {
	/**
	 * @problem LeetCode-209. Given an array of n positive integers and a positive integers,
	 * find the length of a contiguous sub-array of which the sum >= s. If there isn't, return 0.
	 * @solution Two pointers (sliding windows)
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int[] nums = new int[n];
			for(int i=0; i<n; i++) nums[i] = sc.nextInt();
			
			int left = 0, sum = 0;
			int ans = Integer.MAX_VALUE;
	        for(int i=0; i<n; i++){
	            sum += nums[i];
	            while(sum>=s){
	                ans = Math.min(ans, i+1-left);
	                sum -= nums[left++];
	            }
	        }
	        if (ans != Integer.MAX_VALUE) System.out.println(ans);
	        else System.out.println(0);
		}
	}
}
