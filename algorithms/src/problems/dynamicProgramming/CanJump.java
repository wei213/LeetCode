package problems.dynamicProgramming;

public class CanJump {
	/**
	 * Description: Given an array of non-negative integers, you are initially positioned at the first index of the array.
	 * Each element in the array represents your maximum jump length at that position.
	 * Determine if you are able to reach the last index.
	 * @param args
	 */
	
	// Dynamic Programming: searching for solution from the back
	private static boolean dynamicProgramming(int[] nums) {
		if(nums.length == 0 || nums == null) return false;
		int n = nums.length;
		boolean[] dp = new boolean[n];
		dp[n-1] = true;
		for(int i=n-2; i>=0; i--) {
			for(int j=1; j<=nums[i] && j+i<n; j++) {
				if(dp[i+j] == true) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[0];
	}
	// Greedy Search: iteratively search for the most likely solution from the start
	private static boolean greedy(int[] nums) {
		if(nums == null || nums.length == 0) return false;
		int n = nums.length;
		int max = 0;
		for(int i=0; i<n; i++) {
			if(i>max) return false;
			max = Math.max(max, nums[i] + i);
		}
		return true;
	}
	
	public static boolean canJump(int[] nums) {
		return greedy(nums);
	}
	public static void main(String[] args) {
		int[] nums = {3,2,1,0,4};
		System.out.println(canJump(nums));
	}

}
