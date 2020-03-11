package problems.math;

public class SumofTwoIntegers {
	public static int getSum(int a, int b) {
		return b==0?a:getSum(a^b, (a&b)<<1);
	}
	public static void main(String[] args) {
		int a = 3, b = 2;
		System.out.println(getSum(a, b));
	}

}
