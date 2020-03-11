package problems.graph;
import java.util.*;
public class EvaluateDivision {
	
	private static double[] evaluateDivision(List<List<String>> equations, double[] vals, List<List<String>> q) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		for(int i=0; i<equations.size(); i++) {
			map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
			map.putIfAbsent(equations.get(i).get(1), new HashMap<>());
			map.get(equations.get(i).get(0)).put(equations.get(i).get(1), vals[i]);
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / vals[i]);
        }
        double[] r = new double[q.size()];
        for (int i = 0; i < q.size(); i++)
            r[i] = dfs(q.get(i).get(0), q.get(i).get(1), 1, map, new HashSet<>());
        return r;
	}
	
	private static double dfs(String s, String t, double r, Map<String, Map<String, Double>> m, Set<String> seen) {
        for(String str:seen) System.out.print(str);
        System.out.println();
        if (!m.containsKey(s)|| !seen.add(s)) return -1;
        if (s.equals(t)) return r;
        Map<String, Double> next = m.get(s);
        for (String c : next.keySet()) {
            double result = dfs(c, t, r * next.get(c), m, seen);
            if (result != -1) return result;
        }
        return -1;
    }
	public static void main(String[] args) {
		// input
		/* equations = [ ["a", "b"], ["b", "c"] ],
		 * values = [2.0, 3.0],
		 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
		 * 
		 */
		List<List<String>> equations = new ArrayList<>();
		List<String> listOne = new ArrayList<>();
		listOne.add("a");
		listOne.add("b");
		List<String> listTwo = new ArrayList<>();
		listTwo.add("b");
		listTwo.add("c");
		equations.add(listOne);
		equations.add(listTwo);
		
		double[] vals = new double[] {2.0, 3.0};
		List<List<String>> q = new ArrayList<>();
		List<String> quiryI = new ArrayList<>();
		List<String> quiryII = new ArrayList<>();
		List<String> quiryIII = new ArrayList<>();
		List<String> quiryIV = new ArrayList<>();
		List<String> quiryV = new ArrayList<>();
		quiryI.add("a");
		quiryI.add("c");
		quiryII.add("b");
		quiryII.add("a");
		quiryIII.add("a");
		quiryIII.add("e");
		quiryIV.add("a");
		quiryIV.add("a");
		quiryV.add("x");
		quiryV.add("v");
		double[] ans = evaluateDivision(equations, vals, q);
		for(int i=0; i<ans.length; i++) {
			if(i == ans.length -1) System.out.println(ans[i]);
			else System.out.print(ans[i] + " ");
		}
	}
}
