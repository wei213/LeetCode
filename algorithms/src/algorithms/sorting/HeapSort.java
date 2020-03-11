package algorithms.sorting;

public class HeapSort {
	public HeapSort() {}
	
	public void sort(int[] array) {
		int n = array.length;
		for(int i=n/2-1; i>=0; i--) // starts from the last internal node.
			heapify(array, n, i);   // construct heap 
		// above step is to make sure that roots' value or sub-root' value is always
		// larger than its children.
		for(int i=n-1; i>=0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapify(array, i, 0);
		}
	}
	
	static void heapify(int[] array, int n, int i) {
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		if(l<n && array[l] > array[largest]) largest = l;
		if(r<n && array[r] > array[largest]) largest = r;
		if(largest != i) {
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			heapify(array, n, largest);
		}
	}
}
