package problems.sortingAndFinding;

import java.util.*;
public class Search {
	/**
	 * @problem leetcode-81. Search in Rotated Sorted Array II
	 * @description there will be duplicates in the rotated sorted array.
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int target = sc.nextInt();
			int[] nums = new int[n];
			for(int i=0; i<n; i++) nums[i] = sc.nextInt();
			
			int low = 0, high = n-1;
			while(low<high) {
				int mid = low + (high - low)/2;
				if(nums[mid] == target) {
					System.out.println("true");
					return;
				}else if(nums[mid] < nums[high]) {
					if(nums[mid] < target && target <= nums[high]) low = mid+1;
					else high = low-1;
				}else if(nums[mid] > nums[high]) {
					if(nums[low] <= target && target < nums[mid]) high = mid-1;
					else low = mid+1;
				}else {
					high--;
				}
			}
			
			if(nums[low] == target) {
				System.out.println("true");
			}else {
				System.out.println("false");
			}
			return ;
		}
	}

}
