package problems.dynamicProgramming;

public class KnapSack {
	/**
	 * @problem this is a generate framework of KnapSack problem 
	 * @param args
	 */
	
	private static int knapSack(int W, int[] w, int[] v, int n) {
		/**
		 * 0-1 KnapSack problem:
		 * Definition: 
		 * Given weights and values of n items, put these items in a knapsack of capacity W 
		 * to get the maximum total value in the knapsack. 
		 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values 
		 * and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, 
		 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
		 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
		 */
		int[][] k = new int[n+1][W+1];
		for(int i=1; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				if(i == 0 || j == 0) k[i][j] = 0;
				else {
					if(w[i-1] <= j) {
						k[i][j] = Math.max(v[i-1] + k[i-1][j-w[i-1]], k[i-1][j]);
					}else {
						k[i][j] = k[i-1][j];
					}
				}
			}
		}
		
		return k[n][W];
		
	}
	
	public static void canPartition(int[] nums) {
		/**
		 * 0-1 knapSack problem instance
		 * LeeCode-416 Partition Equal Subset Sum. Given a non-empty array containing only positive integers, 
		 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
		 * 
		 * SOLUTION: dp[i][j] represents the first i the can reach to the sum of j. dp[i][j] = dp[i-1][j], first i-1 number
		 * can reach sum of j. dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j], i, j just reach the sum of j under that j>= nums[i-1].
		 * 
		 */
		int n = nums.length;
		int sum = 0;
		for(int num:nums) sum+=num;
		if((sum&1) == 1) {
			System.out.println("false");
			return;
		}
		boolean[][] dp = new boolean[n+1][sum/2+1];
		dp[0][0] = true;
		for(int i=1; i<n; i++) dp[i][0] = true;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum/2+1; j++) {
				if(j >= nums[i-1])
					dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		System.out.println(dp[n][sum/2]);
		return;
		
	}
	
	
	public static void main(String[] args) {
		int W = 50;
		int[] w = {10, 20, 30};
		int[] v = {60, 100, 120};
		int n = 3;
		int ans = knapSack(W, w, v, n);
		System.out.println(ans);
		
		int[] nums = new int[] {1,5,11,5};
		canPartition(nums);
	}
}
