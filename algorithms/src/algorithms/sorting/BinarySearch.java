package algorithms.sorting;

public class BinarySearch {
	
	
	public static boolean binarySearch(int[] nums, int l, int r, int target) {
		while(l<=r) {// difference
			int m = (r+l)/2;
			if(nums[m] == target) {
				return true;
			}else if(nums[m] < target) {
				l = m+1;
			}else {
				r = m-1;
			}
		}
		return false;
	}
	public static void quickSort(int[] nums, int l, int r) {
		if(l<r) {
			int pi = partition(nums, l, r);
			quickSort(nums, l, pi-1);
			quickSort(nums, pi+1, r);
		}
	}
	
	public static int partition(int[] nums, int l, int r) {
		int pivot = nums[r];
		int i = l-1;
		for(int j=l; j<r; j++) {
			if(nums[j]<pivot) {
				i++;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
			}
		}
		int temp = nums[i+1];
		nums[i+1] = pivot;
		nums[r] = temp;
		return i+1;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {3,5,8,3,6,8,1,7};
		quickSort(nums, 0, nums.length-1);
		for(int num: nums)
			System.out.println(num);
		int target = 6;
		System.out.println(binarySearch(nums, 0, nums.length-1, target));
	}
}
