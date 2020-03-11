package algorithms.problems.dynamicProgramming;

/**
 * 
 * @problem LeetCode Best Time To Sell Buy Stock series.
 * @solution one pass
 * @author WEI
 *
 */
public class BestTimeToSellBuyStock {
	
	private static int BestTimeToSellBuyStockI(int[] prices) {
		/*
		 * Through out all the days, there is only one buy and sell, find the maximum profit.
		 * Idea is that to find the maximum gap between the minimum in front of current day price.
		 */
		int ans = 0;
		int n = prices.length;
		if(n < 2) return ans;
		int min = prices[0];
		for(int i=1; i<n; i++) {
			int gap = prices[i] - min;
			if(gap > 0) {
				ans = Math.max(ans,  gap);
				min = Math.min(prices[i], min);
			}
		}
		return ans;
		
	}
	
	private static int BestTimeToSellBuyStockII(int[] prices) {
		/*
		 * Can have many transactions, 
		 * but have to buy before sell, sell before buy
		 */
		int ans = 0;
		int n = prices.length;
		if(n < 2) return ans;
		
		for(int i=1; i<n; i++) {
			int gap = prices[i] - prices[i-1];
			if(gap > 0) ans += gap;
		}
		return ans;
		
	}
	
	private static int BestTimeToSellBuyStockWithCoolDown(int[] prices) {
		/*
		 * Many transactions, but needs to cool-down one day after sell.
		 * buy, sell, cool-down.
		 * buy[i] the maximum profit at the day i with last action as buy
		 * sell[i] the maximum profit at the day i with last action as sell
		 * 
		 * buy[i] is the maximum between buy[i-1] and sell[i-2] - prices, because of a cool-down mechanism after sell. 
		 * it should be sell[i-1-1], if there is k cool-downs after sell, then it is sell[i-1-k].
		 */
		int n = prices.length; 
		if(n < 2) return 0;
		int[] buy = new int[n+1];
		int[] sell = new int[n+1];
		buy[1] = -prices[0];
		for(int i=2; i<=n; i++) {
			int price = prices[i-1];
			buy[i] = Math.max(buy[i-1], sell[i-2] - price);
			sell[i] = Math.max(sell[i-1], buy[i-1] + price);
		}
		return sell[n];
		
	}
	
	private static int BestTimeToSellBuyStockWithFee(int[] prices, int fee) {
		/*
		 * Many transactions, there is a transaction fee for each transaction( buy sell pair).
		 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; 
		 * and a non-negative integer fee representing a transaction fee.
		 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
		 * You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
		 * Return the maximum profit you can make.
		 * 
		 * transaction fee is charged when stock is bought.
		 */
		int n = prices.length;
		if(n < 2) return 0;
		int[] buy = new int[n+1];
		int[] sell = new int[n+1];
		buy[1] = -prices[0]-fee;
		for(int i=2; i<n; i++) {
			int price = prices[i-1];
			buy[i] = Math.max(buy[i-1], sell[i-1] - price - fee);
			sell[i] = Math.max(sell[i-1], buy[i-1] + price);
		}
		return sell[n];
		
	}
	
	private static int BestTimeToSellBuyStockIII(int[] prices) {
		/*
		 * Say you have an array for which the ith element is the price of a given stock on day i.
		 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
		 * You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
		 */
		
		
		
		int n = prices.length;
		int ans = 0;
		if(n < 2) return ans;
		// original solution
		/*
		int[] one = new int[n];
		int min = prices[0];
		for(int i=1; i<n; i++) {
			int gap = prices[i] - min;
			one[i] = Math.max(gap, one[i-1]);
			min = Math.max(min, prices[i]);
		}
		int[] two = new int[n];
		int max = prices[n-1];
		for(int i=n-2; i>=0; i--) {
			int gap = max - prices[i];
			two[i] = Math.max(gap,  two[i+1]);
			max = Math.max(max, prices[i]);
		}
		
		for(int i=1; i<n-2; i++) {
			ans = Math.max(ans, one[i] + two[i+1]);
		}
		ans = Math.max(ans,  one[n-1]);
		return ans;
		*/
		
		// concise solution of using dynamic programming in one pass
		int releaseI = 0, releaseII = 0;
		int holdI = Integer.MIN_VALUE, holdII = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			int price = prices[i];
			holdI = Math.max(holdI, -price);
			releaseI = Math.max(releaseI, price + holdI);
			holdII = Math.max(holdII, -price + releaseI);
			releaseII = Math.max(releaseII, price + holdII);
		}
		
		return releaseII;
	}
	
	private static int BestTimeToSellBuyStockIV(int[] prices, int K) {
		int n = prices.length;
		if(n < 2) return 0;
		// corner case
		if(K >= n/2) return BestTimeToSellBuyStockII(prices);
		
		int[][] dp = new int[K+1][n];
		for(int i=1; i<=K; i++) {
			int tempMax = -prices[0];
			for(int j=1; j<n; j++) {
				dp[i][j] = Math.max(dp[i][j-1], prices[j] + tempMax);
				// t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1])
				// tempMax = t:0->j-1 max(dp[i-1][t-1]-prices[t])
				tempMax = Math.max(tempMax, dp[i-1][j-1] - prices[j]); // update tempMax for the next loop
			}
		}
		return dp[K][n-1];
	}
	
	public static void main(String[] args) {
		int[] prices = new int[] {1,2,3,0,1};
		int ans = 0;
		ans = BestTimeToSellBuyStockI(prices);
		ans = BestTimeToSellBuyStockII(prices);
		System.out.println(ans);
	}
}
