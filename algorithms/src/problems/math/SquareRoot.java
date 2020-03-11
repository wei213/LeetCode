package problems.math;

public class SquareRoot {
	
	private static Double squareRoot(int x) {
		Double target = new Double(x);
		Double low = 1.0, high = new Double(x);
		Double mid = low + (high - low)/2;
		
		while(Math.abs(mid*mid - target)> 1e-7) {
			mid = low + (high - low)/2;
			if(mid*mid < target) low = mid;
			else if(mid*mid > target) high = mid;
			else break;
		}
		
		return mid;
		
	}
	
	private static Double findRoot(int x, int y) {
		return null;
		
	}
	public static void main(String[] args) {
		int x = 49;
		Double ans = squareRoot(x);
		System.out.println(ans);
		ans = squareRoot(x);
		System.out.println(ans);
	}
}
