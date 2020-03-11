package problems.dfs;
import java.util.*;
public class ColorBorder {
	/**
	 * @problem LeetCode 1034. Coloring A Border
	 * @description Given a 2-dimensional grid of integers, 
	 * 	each value in the grid represents the color of the grid square at that location.
	 * 	Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.
	 * 	The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
	 * 	Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.
	 */
	public static int[] d = new int[] {0, 1, 0, -1, 0};
	// solution one: DFS
	public static int[][] colorBorderWithDFS(int[][] grid, int r0, int c0, int color) {
		/*
		 * flip connected components' values to negative first then if is inner component then flip back, otherwise it stays.
		 */
		if(grid == null || grid.length == 0 || grid[0].length == 0) return grid;
		int m = grid.length;
		int n = grid[0].length;
		int oldColor = grid[r0][c0];
		dfs(grid, r0, c0, oldColor);
		
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				if(grid[i][j] == -oldColor)
					grid[i][j] = color;
		
		return grid;
		
	}
	public static void dfs(int[][] grid, int r, int c, int oldColor) {
		grid[r][c] = -oldColor;
		int count = 0;
		for(int i=0; i<4; i++) {
			int x = r + d[i], y = c + d[i+1];
			if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || Math.abs(grid[x][y]) == oldColor) continue;
			count++;
			if(grid[x][y] == oldColor) dfs(grid, x, y, oldColor);
		}
		if(count == 4) grid[r][c] = oldColor;
		
	}
	// solution two: BFS
	public static int[][] colorBorderWithBFS(int[][] grid, int r0, int c0, int color) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return grid;
		Set<Integer> set = new HashSet<>(); //seen
		Stack<Integer> stack = new Stack<>();
		int m = grid.length;
		int n = grid[0].length;
		int oldColor = grid[r0][c0];
		stack.push(r0);
		stack.push(c0);
		set.add(r0*n+c0);
		while(!stack.isEmpty()) {
			int c = stack.pop();
			int r = stack.pop();
			if(r == 0 || c == 0 || r == m-1 || c == n-1) {
				grid[r][c] = color;
				set.add(r*n+c);
			}
			for(int i=0; i<4; i++) {
				int x = r + d[i], y = c + d[i+1];
				if(x < 0 || x >= m || y < 0 || y >= n || set.contains(x*n + y)) continue;
				if(grid[x][y] == oldColor) {
					stack.push(x);
					stack.push(y);
					set.add(x*n+y);
				}else {
					grid[r][c] = color;
					set.add(r*n+c);
				}
			}
			
		}
		
		
		return grid;
	}
}
