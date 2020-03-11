package algorithms.problems.sortingAndFinding;
import java.util.*;

public class FindMin {
	/**
	 * @description LeetCode-153 Find Minimum in Rotated Sorted Array
	 * @solution merge sort
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for(int i=0; i<n; i++) nums[i] = sc.nextInt();
			int high = n-1;
			int low = 0;
			while(low<high) {
				int mid = low + (high - low)/2;
				if(nums[mid] < nums[high]) {
					high = mid;
				}else if(nums[mid] > nums[high]) {
					low = mid + 1;
				}else {
					high--;
				}
			}
			System.out.println(nums[low]);
		}
	}
}
