package problems.slidingWindow;
import java.util.*;
public class FindAnagrams {
	/**
	 * @Description: LeetCode Given a String s and a non-empty String p, find all the start indices
	 * 			     of p's anagrams in s.
	 * @Solution: Sliding window, using hash to record the number of 26 alphabets in the  String p.
	 *            Note: anagram does not care the order of those alphabets in the String s. 
	 *            		cannot be used to find the number of p in the s.
	 * @param args
	 */
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(n == 0 || n<m ) return ans;
        // solution one // Time Limist Exceeded
        
        // char[] pc = p.toCharArray();
        // Arrays.sort(pc);
        // String sortedP = new String(pc);
        // char[] check = new char[m];
        // int index = 0;
        // for(int i=0; i<n; i++){
        //     check[i%m] = s.charAt(i);
        //     String tempStr = new String(check);
        //     char[] tempStrc = tempStr.toCharArray();
        //     Arrays.sort(tempStrc);
        //     tempStr = new String(tempStrc);
        //     if(tempStr.equals(sortedP)) {
        //         ans.add(i-m+1);
        //     }
        // }
        
        int[] hash = new int[26];
        for(char c:p.toCharArray()){
            hash[c-'a']++;
        }
        int st=0, e=0, diff=m;
        while(e<m){
            char c = s.charAt(e);
            if(hash[c-'a'] > 0) diff--;
            hash[c-'a']--;
            e++;
        }
        if(diff == 0) ans.add(0);
        while(e<n){
            char c = s.charAt(st);
            if(hash[c-'a']>=0) diff++;
            hash[c-'a']++;
            st++;
            
            c = s.charAt(e);
            hash[c-'a']--;
            if(hash[c-'a']>=0) diff--;
            e++;
            
            if(diff == 0) ans.add(st);
        }
        return ans;
    }
	
	public static void main(String[] args) {
		
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> ans = findAnagrams(s, p);
		for(int value: ans) System.out.println(value);
	}
}
