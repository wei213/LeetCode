package problems.math;

public class AddStrings {
	/**
	 * @problem LeetCode Add Strings
	 * @param num1
	 * @param num2
	 * @return
	 */
	// plain solution
	public static String addString(String num1, String num2) {
		int len1 = num1.length()-1;
		int len2 = num2.length()-1;
		// improvement 
		StringBuffer ans = new StringBuffer();
		int sign = 0;
		
		while(len1 >=0 || len2 >= 0) {
			int c1 = 0, c2 = 0;
			if(len1 >= 0) c1 = num1.charAt(len1) - '0';
			if(len2 >= 0) c2 = num2.charAt(len2) - '0';
			int sum = c1 + c2 + sign;
			//if(sum == 0) break;
			ans.insert(0, sum%10);
			sign = sum/10;	
			len1--;
			len2--;
		}
		if(sign == 1) ans.insert(0, sign);
		return ans.toString();
	}
	// solution two
	private static String addStrignII(String num1, String num2) {
		if(num1 == null || num1.length() == 0) return num2;
		if(num2 == null || num2.length() == 0) return num1;
		
		int len = num1.length()>num2.length()?num2.length():num1.length();
		int i = 0;
		String ans = "";
		int sign = 0;
		while(i<len) {
			int c1 = num1.charAt(num1.length()-1-i) - '0';
			int c2 = num2.charAt(num2.length()-1-i) - '0';
			int sum = c1 + c2 + sign;
			ans += sum%10;
			sign = sum/10;
			i++;
		}
		System.out.println(ans);
		if(num1.length() > num2.length()) {
			i = num1.length()-len-1;
			while(i>=0) {
				int c = num1.charAt(i) - '0';
				int sum = c + sign;
				ans += sum%10;
				sign = sum/10;
				i--;
			}
		}else {
			i = num2.length()-len-1;
			while(i>=0) {
				int c = num2.charAt(i) - '0';
				int sum = c + sign;
				ans += sum%10;
				sign = sum/10;
				i--;
			}
		}
		System.out.println(ans);
		if(sign == 1) ans += sign;
		int h = 0, t = ans.length()-1;
		char[] chars = ans.toCharArray();
		while(h<t) {
			char c = chars[h];
			chars[h] = chars[t];
			chars[t] = c;
			h++;
			t--;
		}
		return new String(chars);
	}
	public static void main(String[] args) {
		String num1 = "999";
		String num2 = "1039";
		
		System.out.println(addString(num1, num2));
	}
}
