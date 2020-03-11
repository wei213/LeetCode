package problems.sortingAndFinding;

public class SearchMatrix {
	// this class contains two search matrix problems in the LeetCode
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		// matrix is stored with sorted numbers with ascending order.
		// find the value in the matrix that is equal to target.
		
		if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
		
		int h = 0;
		int t = matrix[0].length*matrix.length-1;
		while(h<=t) {
			int mid = h + (t -h)/2;
			int r = mid/matrix[0].length;
			int c = mid%matrix[0].length;
			if(matrix[r][c] == target) return true;
			else if(matrix[r][c] < target) h = mid + 1;
			else t = mid -1;
		}
		return false;
		
	}
	
	public static boolean searchMatrixII(int[][] matrix, int target) {
		// rows are stored with numbers in ascending order.
		// columns are stored with numbers in ascending order.
		if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
		int r = 0;
		int c = matrix[0].length-1;
		while(r <= matrix.length && c>=0) {
			if(matrix[r][c] == target) return true;
			else if(matrix[r][c] < target) r++;
			else c++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
	}

}
