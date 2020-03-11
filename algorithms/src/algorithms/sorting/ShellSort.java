package algorithms.sorting;

public class ShellSort {
	//shell sort, using step size to compare and change each number.
	public void sort(int[] nums) {
		int n = nums.length;
		for(int gap=n/2; gap>0; gap/=2) {
			for(int i=gap; i<n; i++) {
				int temp = nums[i];
				int j=i;
				for(;j>=gap && nums[j-gap] > temp; j-=gap) {
					nums[j] = nums[j-gap];
				}
				nums[j] = temp;
			}
		}
		return ;
	}
}
