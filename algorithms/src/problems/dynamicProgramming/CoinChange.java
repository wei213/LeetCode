package problems.dynamicProgramming;

import java.util.Arrays;

public class CoinChange {
	private static void coinChange(int[] coins, int amount) {
		/**
		 * DESCRIPTION:
		 * You are given coins of different denominations and a total amount of money amount. 
		 * Write a function to compute the fewest number of coins that you need to make up that amount. 
		 * If that amount of money cannot be made up by any combination of the coins, return -1.
		 * 
		 * STATE:
		 * dp[i] the fewest number of coins used to make up to i.
		 * dp[i] = Math.min(dp[i], dp[i-coins[j]]+1); the smallest number of coins needed to make up to i
		 * amount all the the number of coins.
		 * 
		 */
		// solution one;
		int m = coins.length;
		int[] dp = new int[amount+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=1; i<=amount; i++) {
			for(int j=0; j<m; j++) {
				if(i>=coins[j])
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
			}
		}
		System.out.println( dp[amount] == Integer.MAX_VALUE?-1:dp[amount]);
		
	}
	
	private static void coinChangeII(int[] coins, int amount) {
		/**
		 * DESCRIPTION:
		 * You are given coins of different denominations and a total amount of money. 
		 * Write a function to compute the number of combinations that make up that amount. 
		 * You may assume that you have infinite number of each kind of coin.
		 * 
		 * STATE:
		 * dp[i][j] the number of combinations that can make up to j using first i coins.
		 * dp[i][j] = dp[i-1][j] + (j>=coins[i-1]?dp[i][j-coins[i-1]]:0);
		 */
		//Note: the order of the loops matters, to avoid duplications, the outer loop should be coins so that when the coins
		//      will not appear. The inner loop then should be amount
		//solution one;
		int m = coins.length;
		int[][] dp = new int[m+1][amount+1];
		dp[0][0] = 1;
		for(int i=1; i<=m; i++) {
			dp[i][0] = 1;
			for(int j=0; j<amount+1; j++) {
				dp[i][j] = dp[i-1][j] + (j>=coins[i-1]?dp[i][j-coins[i-1]]:0);
			}
		}
		System.out.println(dp[m][amount]);
		
	}
	
	private static void minimumCostForTickets(int[] days, int [] costs) {
		/**
		 * DESCRIPTION:
		 * In a country popular for train travel, you have planned some train travelling one year in advance.  
		 * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
		 * 
		 * Train tickets are sold in 3 different ways:
		 * 	a 1-day pass is sold for costs[0] dollars;
		 * 	a 7-day pass is sold for costs[1] dollars;
		 * 	a 30-day pass is sold for costs[2] dollars.
		 * 
		 * The passes allow that many days of consecutive travel.  
		 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
		 * Return the minimum number of dollars you need to travel every day in the given list of days.
		 */
		//Logics, 
		int m = days.length;
		boolean[] map = new boolean[366];
		for(int day:days) map[day] = true;
		int[] dp = new int[366];
		dp[0] = 0;
		for(int i=1; i<366; i++) {
			if(map[i]) {
				int temp = Math.min(dp[i-1] + costs[0], dp[Math.max(i-7, 0)]+costs[1]);
				dp[i] = Math.min(temp,  dp[Math.max(i-30, 0)]+costs[2]);
			}else {
				dp[i] = dp[i-1];
			}
		}
		System.out.println(dp[365]);
	}
	
	public static void main(String[] args) {
		int[] coins = new int[] {1,2,5};
		int amount = 15;
		coinChange(coins, amount);
		coinChangeII(coins, amount);
		int[] days = new int[] {1,4,6,7,8,20};
		int[] costs = new int[] {2,7,15};
		minimumCostForTickets(days, costs);
	}
}
