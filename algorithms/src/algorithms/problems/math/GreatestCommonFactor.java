package algorithms.problems.math;

import java.util.*;
public class GreatestCommonFactor {
	/**
	 * @solution Greatest Common Factor, solution using Euclidean algorithm
	 * G(a,b) = G(b,r) if a = b*q + r, q is the quotient and r is remainder.
	 * G(a,0) = a
	 * @param args
	 */
	
	public static int gcf(int a, int b) {
		if(b == 0) return a;
		return gcf(b, a%b);
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(gcf(a, b));
			// to compute the lowest common multiple a*b/gcf(a,b)
		}
	}
}
