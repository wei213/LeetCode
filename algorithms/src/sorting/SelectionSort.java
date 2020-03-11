package sorting;

public class SelectionSort {
	public SelectionSort() {}
	
	public void sort(int[] array) {
		int n = array.length;
		for(int i=0; i<n; i++) {
			int min = i;
			for(int j=i+1; j<n; j++)
				if(array[j] < array[min])
					min = j;
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}
