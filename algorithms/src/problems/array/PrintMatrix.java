package problems.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author WEI
 *
 */
public class PrintMatrix {
	/**
	 * @problem LeetCode Print Matrix
	 * @param matrix
	 * @return
	 */
	private static List<Integer> printMatrix(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> list = printMatrix(matrix);
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next());
			// 7391251639
		}
		
	}
}
