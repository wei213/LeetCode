package algorithms.problems.array;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * @problem LeetCode problem
 * @author WEI
 *
 */
public class IntersectioinsOfTwoArrays {
	/**
	 * @param nums1 Integer array
	 * @param nums2
	 * @return
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {
		/*
		 * Find out all the intersections in the two arrays
		 */
		if(nums1.length == 0 || nums1 == null || nums2.length == 0 || nums2 == null)
			return new int[0];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int num: nums1) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		for(int num: nums2) {
			if(map.containsKey(num) && map.get(num)>0) {
				list.add(num);
				map.put(num, map.get(num)-1);
			}
		}
		int[] result = new int[list.size()];
		int i=0;
		for(int num: list) {
			result[i++] = num;
		}
		return result;
	}
	
	public static int[] intersectSort(int[] nums1, int[] nums2) {
		if(nums1.length == 0 || nums1 == null || nums2.length == 0 || nums2 == null)
			return new int[0];
		int i=0, j=0;
		int len1 = nums1.length;
		int len2 = nums2.length;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(i<len1 && j<len2) {
			if(nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			}else if(nums1[i] < nums2[j]) {
				i++;
			}else {
				j++;
			}
		}
		int[] result = new int[list.size()];
		for(int k=0; k<list.size(); k++) {
			result[k] = list.get(k);
		}
		return result;
		
	}
	public static void main(String[] args) {
		int[] result = intersectSort(new int[]{1,2,5,6}, new int[]{1,2,3,4,5,6});
		for(int num: result)
			System.out.print(num + " ");
	}
}
