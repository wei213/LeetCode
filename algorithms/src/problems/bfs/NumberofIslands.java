package problems.bfs;
import java.util.*;
public class NumberofIslands {
	static int[] dr = new int[] {0, 0, 1, -1};
	static int[] dc = new int[] {1, -1, 0, 0};
	
	private static void bfs(char[][] grid, LinkedList<Integer> queue, Set<Integer> set) {
		int r = grid.length;
		int c = grid[0].length;
		while(!queue.isEmpty()) {
			int code = queue.remove();
			int i = code/c, j = code%c;
			for(int k=0; k<4; k++) {
				int ni = i + dr[k];
				int nj = j + dc[k];
				int ncode = ni*c + nj;
				if( 0 <= ni && ni < r && 0 <= nj && nj < c && grid[ni][nj] == '1' && !set.contains(ncode)) {
					queue.add(ncode);
					set.add(ncode);
				}
			}
		}
	}
	
	private static int numberofIslandsWithBFS(char[][] grid) {
		int count = 0;
		int r = grid.length;
		if(r == 0) return count;
		int c = grid[0].length;
		LinkedList<Integer> queue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				int code = i*c+j;
				if(grid[i][j] == '1' && !set.contains(code)) {
					queue.add(code);
					set.add(code);
					bfs(grid, queue, set);
					count++;
				}
			}
		}
		
		return count;
	}
	
	private static void dfs(char[][] grid, int i, int j) {
		int r = grid.length;
		int c = grid[0].length;
		
		if(0 > i || i >= r ||  0 > j || j >= c || grid[i][j] != '1') return;
		grid[i][j] = 0;
		for(int k=0; k<4; k++) {
			dfs(grid, i+dr[k], j+dc[k]);
		}
			
	}
	
	private static int numberofIslandsWithDFS(char[][] grid) {
		int r = grid.length;
		int count = 0;
		if( r == 0) return count;
		int c = grid[0].length;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(grid[i][j] == '1') {
					dfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'1','0','0','1','1'}};
		int ans = numberofIslandsWithBFS(grid); // original solution
		System.out.println(ans);
		ans = numberofIslandsWithDFS(grid);
		System.out.println(ans);
	}
}
