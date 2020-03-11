package problems.dynamicProgramming;
public class UniquePath {
	/**
	 * @problem leetcode-62 Unique Path
	 * @description A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	 * 				The robot can only move either down or right at any point in time. 
	 * 				The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	 * 				How many possible unique paths are there?
	 * @param args
	 */
	private static int uniquePath(int m, int n) {
		if(m < 1 || n < 1) return 0;
		int[][] dp = new int[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0 || j == 0) dp[i][j] = 1;
				else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
					
				}
			}
		}
		return dp[m-1][n-1];
		
	}
	
	private static int dfs(int m, int n) {
		if(m == 1 && n == 1) return 1;
		if(m < 1 || n < 1) return 0;
		return dfs(m-1, n) + dfs(m, n-1);
	}
	public static void main(String[] args) {
		int m = 6;
		int n = 5;
		int ans = 0;
		ans = uniquePath(m, n);
		System.out.println(ans);
		ans = dfs(m, n);
		System.out.println(ans);
	}
}
