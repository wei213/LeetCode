package algorithms.problems.hash;

import java.util.Arrays;

public class TaskScheduler {
	/**
	 * @problem leetcode-621 Task Scheduler
	 * @description Given a char array representing tasks CPU need to do.It contains capital letters A to Z where 
	 * 			 different letters represent different tasks. Tasks could be done without original order. 
	 * 			 Each task could be done in one interval. For each interval, CPU could finish one task or just be idle. 
	 * 			 However, there is a non-negative cooling interval n that means between two same tasks, there must be at
	 * 			 least n intervals that CPU are doing different tasks or just be idle.You need to return the least number
	 * 			 of intervals the CPU will take to finish all the given tasks.
	 * @solution hash to record all the number of tasks. And sort
	 * @param tasks
	 * @param n
	 * @return
	 */
	public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks) map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0) break; // to finish the last one with filling idle time slots.
                if (i < 26 && map[25 - i] > 0) {
                	map[25 - i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
	public static void main(String[] args) {
		char[] tasks = {'A','D','D','A','C','C','D','B','A','B','B','D','A','A','D','A','C','C'};
		char[] test = {'A', 'A', 'A', 'B', 'B', 'B', 'C'};
		int n = 2;
		int ans = leastInterval(test, n);
		System.out.println();
		System.out.println(ans);

	}

}
