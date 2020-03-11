package algorithms.problems.pointers;
import java.util.*;
public class ContainerWithMostWater {
	public static int containerWithMostWater(int[] height) {
		int max = 0;
		int left = 0, right = height.length-1;
		while(left<right) {
			max = Math.max(max, Math.min(height[left], height[right])*(right-left));
			if(height[left] > height[right]) right--;
			else left++;
		}
		return max;
		
	}
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		int max = containerWithMostWater(height);
		System.out.println(max);
	}
}
 