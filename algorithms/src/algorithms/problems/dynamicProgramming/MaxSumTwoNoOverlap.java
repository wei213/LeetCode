package algorithms.problems.dynamicProgramming;
import java.util.*;

public class MaxSumTwoNoOverlap {
	/**
	 * @problem LeetCode-1031
	 * @decription Given an array A of non-negative integers, 
	 * 			   return the maximum sum of elements in two non-overlapping (contiguous) sub-arrays, 
	 * 			   which have lengths L and M.  (For clarification, the L-length sub-array could occur before or after the M-length subarray.)
	 * 			   Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:
	 * @solution record the maximum L-length value and M-length value in one pass.
	 * @param args
	 */
	public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        for(int i=1; i<n; i++) A[i] += A[i-1];
        int res = A[L+M-1], Lmax = A[L-1], Mmax = A[M-1];
        for(int i = L+M; i<n; i++){
            Lmax = Math.max(Lmax, A[i-M] - A[i-L-M]);// record the maximum values 
            Mmax = Math.max(Mmax, A[i-L] - A[i-L-M]);
            res = Math.max(res, Math.max(Lmax + A[i]-A[i-M], Mmax + A[i]-A[i-L]));
        }
        return res;
    }
	public static void main(String[] args) {
		int[] A = new int[] {0,6,5,2,2,5,1,9,4};
		int L = 1;
		int M = 2;
		int ans = maxSumTwoNoOverlap(A, L, M);
		System.out.println(ans);
	}
}
