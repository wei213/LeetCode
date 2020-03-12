package problems.slidingWindow;

/**
 *
 * @problem LeetCode 76
 * @description Given a string S and a string T, 
 * 				find the minimum window in S which will contain all the characters in T in complexity O(n).
 * @solution Two pointers left and right, using sliding window to solve the problem
 * @author WEI
 *
 */
public class MinimumWindowSubstring {
	/**
	 * 
	 * @param s 
	 * @param t
	 * @return String, the characters in the minimum window 
	 */
	public static String minWindow(String s, String t) {
		String ans = "";
		if(s.length() == 0 || t.length() == 0) return ans;
		int[] current = new int[128];
		int[] target = new int[128];
		
		for(int i=0; i<t.length(); i++) {
			target[t.charAt(i)]++;
		}
		int min = Integer.MAX_VALUE;
		int l=0, r=0, formed=0;
		while(r<s.length()) {
			char c = s.charAt(r);
			if(target[c]>0) {
				if(target[c]>current[c]) formed++;
				current[c]++;
			}
			
			if(formed == t.length()) {
				c = s.charAt(l);
				while(target[c] == 0 || target[c]<current[c]) {
					if(target[c] < current[c]) {
						current[c]--;
					}
					l++;
					c = s.charAt(l);
				}
				
				int len = r-l+1;
				if(min > len) {
					min = len;
					ans = s.substring(l, r+1);
				}
			}
			r++;
		}
		return ans;
		
	}
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
}
