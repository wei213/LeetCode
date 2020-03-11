package problems.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatedCharacters {
	private static int longestSubstringWithoutRepeatedCharacters(String s) {
		if(s == null || s.length() == 0) return 0;
		int ans = Integer.MIN_VALUE;
		Set<Character> set = new HashSet<>();
		int i=0, j=0;
		int n = s.length();
		while(i<n && j<n) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				ans = Math.max(ans, j-i+1);
				j++;
			}
			else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String s = "abcdddsef";
		int ans = longestSubstringWithoutRepeatedCharacters(s);
		System.out.println(ans);
	}
}
