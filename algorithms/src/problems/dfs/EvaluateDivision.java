package problems.dfs;
import java.util.*;
public class EvaluateDivision {
	/**
	 * @problem leetcode-399. Evaluate Divisioin
	 * @solution find the path from one node to another node.
	 * 			 can consider the searching process and concept into a graph searching.
	 * 			 given two nodes, find the path ans sum over the value between them.
	 * @param equations
	 * @param values
	 * @param q
	 * @return
	 */
	private static double[] evaluateDivision(List<List<String>> equations, double[] values, List<List<String>> q) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		
		for(int i=0; i<equations.size(); i++) {
			String a = equations.get(i).get(0);
			String b = equations.get(i).get(1);
			map.putIfAbsent(a, new HashMap<>());
			map.putIfAbsent(b, new HashMap<>());
			map.get(a).put(b, values[i]);
			map.get(b).put(a, 1/values[i]);
		}
		
		double[] ans = new double[q.size()];
		for(int i=0; i<q.size(); i++) {
			String a = q.get(i).get(0);
			String b = q.get(i).get(1);
			ans[i] = dfs(a, b, 1, map, new HashSet<String>());
		}
		return ans;
	}
	
	private static double dfs(String a, String b, double r, Map<String, Map<String, Double>> map, HashSet<String> seen) {
		if(!map.containsKey(a) || !seen.add(a)) return -1;
		if(a.equals(b)) return r;
		Map<String, Double> next = map.get(a);
		for(String key:next.keySet()) {
			double result  = dfs(key, b, r*next.get(key), map, seen);
			if(result != -1) return result;
		}
		return -1;
			
	}
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		List<List<String>> input = new ArrayList<>();
		List<String> one = new ArrayList<>();
		one.add("a");
		one.add("b");
		input.add(one);
		List<String> two = new ArrayList<>();
		two.add("b");
		two.add("c");
		input.add(two);
		double[] values = new double[2];
		values[0] = 2.0;
		values[1] = 3.0;
		List<List<String>> quires = new ArrayList<>();
		List<String> I = new ArrayList<>();
		I.add("a");
		I.add("c");
		List<String> II = new ArrayList<>();
		II.add("b");
		II.add("a");
		List<String> III = new ArrayList<>();
		III.add("a");
		III.add("e");
		List<String> IV = new ArrayList<>();
		IV.add("a");
		IV.add("a");
		List<String> V = new ArrayList<>();
		V.add("x");
		V.add("x");
		quires.add(I);
		quires.add(II);
		quires.add(III);
		quires.add(IV);
		quires.add(V);
		double[] ans = evaluateDivision(input, values, quires);
		for(double d:ans)
			System.out.print(d + " ");
	}
}
