package problems.sortingAndFinding;

public class KthLargestElements {
	// time complexity  O(n), logk k is the depth of binary tree, n is for each depth
	// but each time, we will only search for the left or right;
	// the total number is n.
	private static int partition(int[] nums, int h, int t) {
		int pivot = nums[t];
		int i = h-1;
		for(int j=h; j<t; j++) {
			if(nums[j] > pivot) {
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i+1, t);
		return i+1;
		
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	private static void quickSort(int[] nums, int h, int t, int index) {
		if(h<t) {
			int pi = partition(nums, h, t);
			if(pi > index)
				quickSort(nums, h, pi-1, index);
			if(pi < index)
				quickSort(nums, pi+1, t, index);
		}
		return ;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {2, 5, 8, 3, 5, 6, 9, 1, 3, 2, 7, 9};
		int k = 7;
		quickSort(nums, 0, nums.length-1, k);
		int ans = nums[k-1];
		for(int num:nums) System.out.print(num + " ");
		System.out.println("ans:" + ans);
	}
}
