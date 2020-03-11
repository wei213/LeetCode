package algorithms.problems.math;

import java.util.Arrays;

public class PerfectSquares {
	/**
	 * @problem LeetCode279 Perfect Squares.
	 * @description Given a positive integer n, 
	 * 				find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * @solution dynamic programming. 
	 * @param n
	 * @return
	 */
	//solution DP
	private static int perfectSquares(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j*j<=i; j++) { // the squares that are smaller than the current value.
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int n = 12;
		int ans = perfectSquares(n);
		System.out.println(ans);
	}
}
