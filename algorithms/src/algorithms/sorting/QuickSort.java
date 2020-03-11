package algorithms.sorting;

public class QuickSort {
	
	public QuickSort() {}
	// sort(array, 0, array.length-1);
	public void sort(int[] array, int l, int h) {
		if(l<h) {
			int pi = partition(array, l, h);
			sort(array, l, pi-1);
			sort(array, pi+1, h);
		}
	}
	
	static int partition(int[] array, int l, int h) {
		int pivot = array[h];
		int i = l-1;// the first number index that is larger than pivot.
		for(int j=l; j<h; j++) {
			if(array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i+1];
		array[i+1] = array[h];
		array[h] = temp;
		return i+1;
	}
}
