package algorithms.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class ListNode {
	int val;
    ListNode next;
    ListNode(int x) {
    	val = x;
        next = null;
        }
}

public class Main{
	public static void anser() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // lines
        if(n > 300) n = 300;
        if(n <= 1) return;
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                graph[i][j] = in.nextInt();
            }
        }
        int count = Integer.MIN_VALUE;
        int ans = -1;
        while(in.hasNext()){
            int index = in.nextInt();
            if(index < 0 || index >= n*n) continue;
            int r = index/n;
            int c = index%n;
            HashSet<Integer> seen = new HashSet<>();
            seen.add(r*n+c);
            int temp = dfs(graph, r, c, seen);
            if(temp > count){
            	System.out.println("index:" + index);
                count = temp;
                ans = index;
            }
        }
        System.out.println(ans);
	}
	
	private static int dfs(int[][] graph, int r, int c, HashSet<Integer> seen){
        if(r<0 || c < 0 || r >= graph.length || c >= graph.length || graph[r][c] == 0 || seen.contains(r*graph.length + c)) return 0;
        seen.add(r*graph.length + c);
        int count = 0;
        count += dfs(graph, r-1, c, seen) + dfs(graph, r+1, c, seen) + dfs(graph, r, c-1, seen) + dfs(graph, r, c+1, seen)+1;
        return count;
    }
	
	// LeetCode problem
	public static String countAndSay(int n) {
        String ans = "";
        if(n < 1) return ans;
        ans = "1";
        for(int i=1; i<n; i++){
            if(n == 1) break;
            StringBuffer temp = new StringBuffer();
            int count = 0;
            char pre = ans.charAt(0);
            for(int j=0; j<ans.length(); j++){
                if(pre == ans.charAt(j)){
                    count++;
                }else{
                    temp.append(count);
                    temp.append(String.valueOf(ans.charAt(j-1)));
                    count = 1;
                }
                pre = ans.charAt(j);
            }
            
            if(count != 0){
                temp.append(count);
                temp.append(String.valueOf(pre));
            }
            
            ans = temp.toString();
            System.out.println((i+1) + " " + ans);
        }
        return ans;
    }
	
	public static void huawei() {
		Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<String> list = new ArrayList<String>();
            print(n, k, "", list);
            System.out.println(list.size());
            for(int i=list.size()-1; i>=0; i--){
                System.out.println(list.get(i));
            }
        }
    }
    
    public static void print(int n, int k, String cur, ArrayList<String> list){
        if(n == 0){
            String temp = "";
            temp += cur;
            for(int i=1; i<k; i++){
                temp += "|";
            }
            list.add(temp);
            return;
        }else if(k == 1) {
            String temp = "";
            temp += cur;
        	for(int i=0; i<n; i++) {
        		temp += "*";
        	}
        	list.add(temp);
            return;
        }
        
        for(int i=0; i<=n; i++){
            String temp = "";
            for(int j=0; j<i; j++){
                temp += "*";
            }
            print(n-i, k-1, new String(cur+temp + "|"), list);
        }
	}
    
    
    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
    
    static int ans = Integer.MAX_VALUE;
    private static int solution(int[] input) {

        // TODO Write your code here
        int n = input.length;
        int total = 0;
        for(int i=0; i<n; i++){
            total += input[i];
        }
        int half = n/2;
        search(input, 0, 0, 0, half, total);
        return ans;
    }
    
    private static void search(int[] input, int currSum, int count ,int index, int half, int total){
        if(count == half){
            int gap = Math.abs(total-2*currSum);
            ans = Math.min(ans, gap);
            return;
        }
        
        for(int i=index; i<input.length; i++){
            currSum += input[i];
            search(input, currSum, count+1, i+1, half, total);
            currSum -= input[i];
        }
    }
    public static int solution (int n) {
        // write code here
        int ans = 0;
        if(n == 0) return ans;
        int day = 1;
        int value = 1;
        int pre = 1;
        for(int i=1; i<=n; i++){
            ans += value;
            day--;
            if(day == 0){
                day = pre + 1;
                pre++;
                value++;
            }
        }
        return ans;
    }
    
    static int result = 0;
    static int[][] filter = new int[10][10];
    static int[] stamp = new int[9];
    static boolean[] vis = new boolean[10];
    static int target = 0;
    public static int solution (int m, int n) {
        // write code here
        filter[1][3] = filter[3][1] = 2;
        filter[4][6] = filter[6][4] = 5;
        filter[7][9] = filter[9][7] = 8;
        filter[1][7] = filter[7][1] = 4;
        filter[2][8] = filter[8][2] = 5;
        filter[3][9] = filter[9][3] = 6;
        filter[1][9] = filter[9][1] = 5;
        filter[3][7] = filter[7][3] = 5;
        vis[0] = true;
        target = m;
        search(0);
        stamp = new int[9];
        vis = new boolean[10];
        vis[0] = true;
        target = n;
        search(0);
        
        return result;
    }
    
    public static void search(int count){
        if(count == target){
            result++;
            return;
        }
        for(int i=1; i<=9; i++){
            if(count>0 && !vis[filter[stamp[count-1]][i]]) continue;
            if(!vis[i]){
                vis[i] = true;
                stamp[count]=i;
                search(count+1);
                vis[i] = false;
            }
        }
    }
	//-------------------------------------------------------------
    public static void main(String[] args) throws Exception {
    	String st = "maipiao,,duide,shima,ke";
    	String[] words = st.split(",");
        for(String word : words)
        	System.out.println(word);
    }

    
	//---------------------------------------------------------------
}
    