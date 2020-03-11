package problems.math;

public class UglyNumber {
	/**
	 * @problem LeetCode Ugly Number
	 * @description Ugly numbers are positives numbers that whose prime factors only contain 2, 3, 5
	 * @param n
	 * @return
	 */
	private static int uglyNumberII(int n) {
		// find n-th ugly number.
		if(n < 8) return n;
		int[] nums = new int[n];
		int i2=0, i3=0, i5=0;
		nums[0]=1;
		for(int i=0; i<n; i++) {
			int min = Math.min(nums[i2]*2, Math.min(nums[i3]*3, nums[i5]*5));
			nums[i] = min;
			if(min == nums[i2]*2) i2++;
			if(min == nums[i3]*3) i3++;
			if(min == nums[i5]*5) i5++;
		}
		return nums[n-1];
	}
	
	private static boolean uglyNubmerI(int n) {
		// if given number n is ugly number
		if(n <= 0) return false;
		while(n%2 == 0) n >>= 1;
		while(n%3 == 0) n /= 3;
		while(n%5 == 0) n /= 5;
		if(n == 1) return true;
		return false;
	}
	public static void main(String[] args) {
		int n = 12;
		int ans = uglyNumberII(n);
		System.out.println(ans);
		n = 12;
		System.out.println(uglyNubmerI(n));
	}
}
