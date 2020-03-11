package algorithms.problems.sortingAndFinding;

public class SingleNumber {
	
	private static int singleNumber(int[] nums) {
		int n = nums.length;
		int ans = 0;
		for(int i=0; i<n; i++) {
			ans = ans^nums[i];
		}
		return ans;
	}
	public int[] singleNumberII(int[] nums) {
        int temp = 0;
        for (int n : nums) {
            temp ^= n;
        }
        int mask = -temp & temp;
        //keep the last digit that is 1 which means that bits of two target numbers at that position 
        //is different
        int single1 = 0, single2 = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                single1 ^= num;
            } else {
                single2 ^= num;
            }
        }
        return new int[] {single1, single2};
    }
	public static void main(String[] args) {
		int[] nums = new int[] {1,1,3,3,5,5,6,6,8,9,8};
		System.out.println(singleNumber(nums));
	}
}
