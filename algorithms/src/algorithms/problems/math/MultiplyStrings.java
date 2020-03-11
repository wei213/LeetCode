package algorithms.problems.math;

public class MultiplyStrings {
	/**
	 * @problem LeetCode 43 Multiply Strings
	 * @param strI
	 * @param strII
	 * @return
	 */
	private static String multiplyStrings(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int[] array = new int[len1+len2];
		for(int i=len1-1; i>=0; i--) {
			for(int j=len2-1; j>=0; j--) {
				int mul = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
				int p1 = i+j, p2 = i+j+1;
				int sum = array[p2] + mul;
				array[p1] = sum/10;
				array[p2] = sum%10;
			}
		}
		StringBuffer ans = new StringBuffer();
		for(int value: array) {
			if(!(ans.length() == 0 && value == 0))
				ans.append(value);
		}
		return ans.length()==0?"0":ans.toString();
	}
	public static void main(String[] args) {
		String strI = "314300";
		String strII = "120420";
		String ans = multiplyStrings(strI, strII);
		System.out.println(ans);
	}
}
