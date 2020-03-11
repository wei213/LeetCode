package algorithms.sorting;

public class RecursiveInsertionSort {
	public RecursiveInsertionSort() {}
	
	public void sort(int[] array, int n) {
		if(n <= 1) return ;
		sort(array, n-1);
		int key = array[n-1];
		int j = n-2;
		while(j>=0 && array[j]>key) {
			array[j+1] = array[j];
			j = j-1;
		}
		array[j+1] = key;
	}
}
