package algorithms.problems.dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestIncresaingSubsquence {
	/**
	 * @problem LeetCode 300 Longest Increasing Subsequence
	 * @description 
	 * @param nums
	 * @return
	 */
	// solution one 
	//O(n^2) time complexity, O(n) space complexity
	public static int longestincreasingSubsequence(int[] nums) {
		if(nums == null  || nums.length == 0) return 0;
		int n = nums.length;
		int[] dp = new int[n];
		int ans = 0;
		Arrays.fill(dp, 1);
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i])
					dp[i] = Math.max(dp[i],  dp[j]+1);
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
	//O(nlogn) time complexity O(n) space complexity
	public static int secondSolution(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int len = 0;
		for(int num: nums) {
			int i = binarySearch(dp, 0, len, num); // binarySearch O(logn)
			if(i<0) i = -(i+1);
			dp[i] = num;
			if(i == len) len++;
		}
		return len;
	}
	private static int binarySearch(int[] dp, int h, int t, int num) {
		while(h != t){
            int mid = h + ( t - h)/2;
            if(dp[mid] < num) h = mid + 1;
            else t = mid;
        }
        return -t-1;
	}
	

	/**
	 * @problem Russian Doll Envelopes
	 * 
	 */
	// longest increasing subsequence expanded to two dimension. can use dynamic programming to 
	// solve the problem, but in the LeetCode, time limit exceeded. time complexity with O(n^2);
	// but with greedy and binary search, time complexity is reduced to O(nlogn)
	
	/*
	 * Solution: sort the width in a ascending order and then, 
	 * 			 sort the two-dimensional array with height with decreasing order
	 */
	public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] envelop1, int[] envelop2){
                if(envelop1[0] != envelop2[0]){
                    return envelop1[0] - envelop2[0];
                }
                return envelop2[1] - envelop1[1];
            }
        });
        
        int[] dp = new int[n];
        
        dp[0] = envelopes[0][1];
        int end = 0;
        for(int i=1; i<n; i++){
            int target = envelopes[i][1];
            if(target > dp[end]){
                dp[++end] = target;
            }else{
                int l = 0;
                int r = end;
                while(l<r){
                    int m = (r-l)/2 + l;
                    if(dp[m] < target) l = m+1;
                    else r = m;
                }
                dp[l] = target;                
            }
        }
        return end+1;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {10,9,2,5,3,7,101,18};
		int ans = longestincreasingSubsequence(nums);
		System.out.println(ans);
		ans = secondSolution(nums);
		System.out.println(ans);
	}
}
