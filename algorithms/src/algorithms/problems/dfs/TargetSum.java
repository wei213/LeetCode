package algorithms.problems.dfs;
import java.util.*;
public class TargetSum {
	
	private static int targetSum(int[] nums, int s) {
		if(nums == null || nums.length == 0) return 0;
		int count;
		count = simpleDFS(nums, 0, 0, s);
		count = dfsWithMemorisation(nums, 0, 0, s, new HashMap<>());
		count = dp(nums, s);
		return count;
	}
	
	// Third solution
	private static int dp(int[] nums, int s) {
		/**
		 * Derived from the concept of 0-1 KnapSack problem. 
		 * dp[i][j] represents the numbers under the case that there are i items with maximum weight at j.
		 * here j is in the range of all the possible sum that the values in the array can reach.
		 */
		int n = nums.length;
		int sum = 0;
		for(int num: nums) sum += num;
		if(s > sum || s < -sum) return 0;
		int[][] dp = new int[n+1][2*sum+1];
		// from the range of -sum to sum, indicated by indices 0 to 2*sum with j.
		dp[0][sum] = 1; // base case
		for(int i=1; i<n+1; i++) {
			for(int j=0; j<2*sum+1; j++) {
				if(j + nums[i-1] < 2*sum+1) dp[i][j] +=  dp[i-1][j + nums[i-1]];
				if(j - nums[i-1] >= 0) dp[i][j] += dp[i-1][j - nums[i-1]];
			}
		}
		return dp[n][sum + s];
	}
	
	// Second solution
	private static int dfsWithMemorisation(int[] nums, int i, int curSum, int s, Map<String, Integer> map) {
		/**
		 * deep first search with memorisation that stores the intermediate sum that appears in the recursive tree.
		 */
		if(i == nums.length) {
			if( s == curSum) return 1;
			else return 0;
		}
		String key = i+"-"+curSum;
		if(map.containsKey(key)) return map.get(key);
		
		int positive = dfsWithMemorisation(nums, i+1, curSum + nums[i], s, map);
		int negative = dfsWithMemorisation(nums, i+1, curSum - nums[i], s, map);
		map.put(key, negative+positive);
		return negative+positive;
	}
	
	// solution one
	private static int simpleDFS(int[] nums, int i, int curSum, int s) {
		/**
		 * simple deep first search, but there is a lot of overlapping of the same values in the recursive tree.
		 */
		if(i == nums.length) {
			if(s == curSum) return 1;
			return 0;
		}
		int count = 0;
		count += simpleDFS(nums, i+1, curSum-nums[i], s) + simpleDFS(nums, i+1, curSum+nums[i], s);
		return count ;
		
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		int s = 3;
		int count = targetSum(nums, s);
		System.out.println(count);
	}
}
