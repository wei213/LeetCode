package algorithms.problems.dfs;

import java.util.Arrays;

public class CanPartitionKSubsets {
	/**
	 * @problem LeetCode 698 Can Partition K Subsets
	 * @description Given an array of integers nums and a positive integer k, 
	 * 				find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
	 * @param groups
	 * @param row
	 * @param nums
	 * @param target
	 * @return
	 */
	// standard solution
	public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break;
        }
        return false;
    }

    public boolean canPartitionKSubsetsI(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }
    // second solution slow but deal with negative numbers as well.
    
    public boolean canPartitionKSubsetsII(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<nums.length; i++) sum+=nums[i];
        if(sum%k != 0) return false;
        
        int target = sum/k;
        boolean[] visited = new boolean[n];
        return search(nums, k, visited, 0, 0, target);
    }
    
    private boolean search(int[] nums, int k, boolean[] visited, int start, int currSum, int target){
        if(k == 0) return true;
        if(target == currSum) return search(nums, k-1, visited, 0, 0, target);
        
        for(int i=start; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(search(nums, k, visited, i+1, currSum+nums[i], target)) return true;
                visited[i] = false;
            }
        }
        
        return false;
    }
    // Third solution numbers in the nums array are positive integers.
    public boolean canPartitionKSubsetsIII(int[] A, int k) {
        if (k > A.length) return false;
        int sum = 0;
        for (int num : A) sum += num;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[A.length];
        Arrays.sort(A);
        return dfs(A, 0, A.length - 1, visited, sum / k, k);
    }

    public boolean dfs(int[] A, int sum, int st, boolean[] visited, int target, int round) {
        if (round == 0) return true;
        if (sum == target && dfs(A, 0, A.length - 1, visited, target, round - 1))
            return true;
        for (int i = st; i >= 0; --i) {
            if (!visited[i] && sum + A[i] <= target) {
                visited[i] = true;
                if (dfs(A, sum + A[i], i - 1, visited, target, round))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
