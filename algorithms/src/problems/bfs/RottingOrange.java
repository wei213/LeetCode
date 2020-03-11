package problems.bfs;
import java.util.*;
public class RottingOrange {
	/**
	 * @problem LeetCode-994 Rotting Orange
	 * @description In a given grid, each cell can have one of three values:
	 * 		the value 0 representing an empty cell;
	 * 		the value 1 representing a fresh orange;
	 * 		the value 2 representing a rotten orange.
	 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
	 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
	 *@solution breadth first search. store the rotten orange in the queue, and the position and depth into map
	 */
	static int[] dr = new int[] {0, 0, -1, 1};
	static int[] dc = new int[] {1, -1, 0, 0};
	public static int rottingOrange(int[][] grid) {
		int R = grid.length;
		int C = grid[0].length;
		
		Queue<Integer> queue = new ArrayDeque<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int r=0; r<R; r++) 
			for(int c=0; c<C; c++) 
				if(grid[r][c] == 2) {
					int code = r*C + c;
					queue.add(code);
					map.put(code, 0);
				}
		int ans = 0;
		while(!queue.isEmpty()) {
			int code = queue.remove();
			int r = code/C, c = code%C;
			for(int k=0; k<4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
					int ncode = nr*C + nc;
					queue.add(ncode);
					map.put(ncode, map.get(code) + 1);
					grid[nr][nc] = 2;
					ans = map.get(ncode);
				}
			}
		}
		
		for(int r=0; r<R; r++)
			for(int c=0; c<C; c++)
				if(grid[r][c] == 1)
					return -1;
		return ans;
	}
	
	public static void main(String[] args) {
		int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
		int ans = rottingOrange(grid);
		System.out.println(ans);
	}
}
