package algorithms.sorting;

public class RecursiveBubbleSort {
	public RecursiveBubbleSort() {}
	
	public void sort(int[] array, int n) {
		if(n <= 1) return ;
		for(int i=0; i<n-1; i++) {
			if(array[i] > array[i+1]) {
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}
		sort(array, n-1);
	}
}
