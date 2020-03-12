package problems.pointers;
import java.util.*;

/**
 * @problem LeetCode560 Given an array of integers and an integer k, 
 * 			you need to find the total number of continuous sub-arrays whose sum equals to k.
 * 			Note that K can be negative and positive, and values in the arrays are too.
 * @solution pointers. two pass.
 * @author WEI
 *
 */
public class SubarraySumEqualsK {
	
	public int subarraySum(int[] nums, int k) {
	    if (nums == null || nums.length == 0) return 0;
	    int left = 0;
	    int right = 1;
	    int count = 0;
	    int sum = nums[left];
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] == k) count++;
	    }
	    while (left < nums.length - 1 && right < nums.length) {
	        sum += nums[right];
	        if (sum == k) count++;
	        right++;
	        if (right == nums.length) {
	            left += 1;
	            right = left + 1;
	            sum = nums[left];
	            continue;
	        }
	    }
	    return count;
	}
	
	public static int subarraySumEqualsK(int[] nums, int k) {
		int count = 0;
		int n = nums.length;
		if(n == 0) return count;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum += nums[j];
				if(sum == k) count++;
			}
		}
		return count;
	}
	
	@SuppressWarnings("unused")
	private static int subarraySumEqualsKWithMap(int[] nums, int k) {
		int count = 0;
		int n = nums.length;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			sum += nums[i];
			if(map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0)+ 1);
		}
		return count;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {1,1,1};
		int k = 2;
		int ans = subarraySumEqualsK(nums, k);
		System.out.println(ans);
	}
}
