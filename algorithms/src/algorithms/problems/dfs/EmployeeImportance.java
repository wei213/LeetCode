package algorithms.problems.dfs;

import java.util.*;

class Employee{
	int id;
	int importance;
	ArrayList<Integer> subordinates;
	Employee(int id, int importance, ArrayList<Integer> subordinates){
		this.id = id;
		this.importance = importance;
		this.subordinates = subordinates;
	}
}
public class EmployeeImportance {
	/**
	 * @problem leetcode-690 Employee Importance
	 */
	static Map<Integer, Employee> map;
	private static int solutionTwo(List<Employee> employees, int id) {
		map = new HashMap<>();
		for(Employee employee: employees) map.putIfAbsent(employee.id, employee);
		return dfs(id);
	}
	
	private static int dfs(int id) {
		Employee employee = map.get(id);
		int ans = employee.importance;
		for(Integer subID: employee.subordinates)
			ans += dfs(subID);
		return ans;
	}
	
	public static int solutionOne(List<Employee> employees, int id) {
		if(employees.size() == 0) return 0;
		int ans = 0;
		for(Employee employee: employees) {
			if(employee.id == id) {
				ans += employee.importance;
				ArrayList<Integer> subordinates = employee.subordinates;
				for(Integer subordinate: subordinates) {
					ans += solutionOne(employees, subordinate);
				}
			}
		}
		return ans;
		
	}
	public static void main(String[] args) {
		// [[1,5,[2]],[2,8,[]]], 1
		int id = 1;
		List<Employee> employees = new ArrayList<>();
		
		ArrayList<Integer> listOne = new ArrayList<>();
		listOne.add(2);
		Employee one = new Employee(1, 5, listOne);
		ArrayList<Integer> listTwo = new ArrayList<>();
		Employee two = new Employee(2, 8, listTwo);
		
		employees.add(one);
		employees.add(two);
		int ans = 0;
		ans = solutionOne(employees, id);
		System.out.println(ans);
		map = new HashMap<>();
		ans = solutionTwo(employees, id);
		System.out.println(ans);
	}
}
