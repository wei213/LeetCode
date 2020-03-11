package algorithms.problems.dynamicProgramming;

import java.util.Set;

public class minCostTickets {
	private static void mincostTickets(int[] days, int[] costs) {
		/**
		 * In a country popular for train travel, you have planned some train travelling one year in advance.
		 * The days of the year that you will travel is given as an array days. 
		 * Each day is an integer from 1 to 365.
		 *    Train tickets are sold in 3 different ways:
		 *    	a 1-day pass is sold for costs[0] dollars;
		 *    	a 7-day pass is sold for costs[1] dollars;
		 *    	a 30-day pass is sold for costs[2] dollars.
		 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2,
		 * then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
		 * Return the minimum number of dollars you need to travel every day in the given list of days.
		 * 
		 */
		
		// Set<Integer> set = new HashSet<>();
        // for(int day:days) set.add(day);
        // int[] memo = new int[366];
        // return dp(1, costs, memo, set);
		
		boolean[] map = new boolean[366];
		int[] minCost = new int[366];
		for(int day:days) map[day] = true;
		minCost[0] = 0;
		for(int i=1; i<366; i++) {
			if(map[i]) {
				int temp = Math.min(minCost[i-1] + costs[0], minCost[Math.max(i-1,  0)] + costs[1]);
				minCost[i] = Math.min(temp,  minCost[Math.max(i-30, 0)] + costs[2]);
			}else {
				minCost[i] = minCost[i-1];
			}
		}
		System.out.println(minCost[365]);
	}
	//solution one; bottom up dynamic programming
	private int dp(int i, int[] costs, int[] memo, Set<Integer> set){
        if(i>365) return 0;
        if(memo[i] != 0) return memo[i];
        int ans;
        if(set.contains(i)){
            int temp = Math.min(dp(i+1, costs, memo, set) + costs[0], dp(i+7,costs, memo, set) + costs[1]);
            ans = Math.min(temp, dp(i+30, costs, memo, set) + costs[2]);
        }else{
            ans = dp(i+1, costs, memo, set);
        }
        memo[i] = ans;
        return ans;
    }
	
	public static void main(String[] args) {
		int[] days = new int[] {1,4,6,7,8,20};
		int[] costs = new int[] {2,7,15};
		mincostTickets(days, costs);
	}
}
