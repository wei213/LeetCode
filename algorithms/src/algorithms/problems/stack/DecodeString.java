package algorithms.problems.stack;
import java.util.*;
public class DecodeString {
	/**
	 * @problem LeetCode-394 Decode String
	 * @Description Given an encoded string, return its decoded string.
	 * @solution using stack to store the string and nums in the given string s.
	 * @param s
	 * @return
	 */
	public static String decodeString(String s) {
		String ans = "";
		//ans = initialSolution(s);
		ans = referencedSolution(s);
		return ans;
		
	}
	
	private static String referencedSolution(String s) {
		int n = s.length();
		String ans = "";
		if(n == 0) return ans;
		Stack<String> strStack = new Stack<>();
		Stack<Integer> numStack = new Stack<>();
		
		int start = 0;
		while(start < n) {
			char c = s.charAt(start);
			if(Character.isDigit(c)) {
				int num = 0;
				while(Character.isDigit(c)) {
					num = num*10 + c -'0';
					start++;
					c = s.charAt(start);
				}
				numStack.push(num);
			}else if(c == '[') {
				strStack.push(ans);
				ans = "";
				start++;
			}else if(c == ']') {
				int num = numStack.pop();
				StringBuffer temp = new StringBuffer(strStack.pop());
				for(int i=0; i<num; i++) {
					temp.append(ans);
				}
				ans = temp.toString();
				strStack.push(ans);
				start++;
			}else {
				ans += c;
				start++;
			}
		}
		return ans;
		
	}
	private static String initialSolution(String s) {
		StringBuffer ans = new StringBuffer();
		int n = s.length();
		if(0 == n) return ans.toString();
		int start = 0;
		Stack<Character> stack = new Stack<>();
		while(start < n) {
			char c = s.charAt(start);
			if( c == ']') {
				String str = "";
				String nums = "";
				char r;
				while((r = stack.pop()) != '['){
					str = r + str;
				}
				while(!stack.isEmpty() && stack.peek() <= '9' && stack.peek() >= '0') {
					nums = stack.pop() + nums;
				}
				for(int i=0; i<Integer.parseInt(nums); i++) {
					for(int j=0; j<str.length(); j++) {
						stack.push(str.charAt(j));
					}
				}
			}else {
				stack.push(c);
			}
			start++;
		}
		while(!stack.isEmpty()) ans.append(stack.pop());
		return ans.reverse().toString();
		
	}
	
	public static void main(String[] args) {
		String s = "2[e10[e]t3[co]de]";
		String ans = decodeString(s);
		System.out.println(ans);
	}
}
