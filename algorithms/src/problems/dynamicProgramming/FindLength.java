package problems.dynamicProgramming;
import java.util.*;
public class FindLength {
	/**
	 * @problem Maximum Length  of Repeated Sub-array
	 * @description Given two integer arrays A and B, return the maximum length of an 
	 * sub-array that appears in both arrays.
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[] A = new int[m];
			int[] B = new int[n];
			for(int i=0; i<m; i++) A[i] = sc.nextInt();
			for(int j=0; j<n; j++) B[j] = sc.nextInt();
			
			int ans = 0;
			int[][] dp = new int[m+1][n+1];
			for(int i=m-1; i>=0; i--) {
				for(int j=n-1; j>=0; j--) {
					if(A[i] == B[j]) dp[i][j] = dp[i+1][j+1] + 1;
					if(ans < dp[i][j]) ans = dp[i][j];
				}
			}
			
			System.out.println(ans);
		}
	}
}
