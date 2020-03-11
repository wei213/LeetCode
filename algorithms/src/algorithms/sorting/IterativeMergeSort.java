package algorithms.sorting;

public class IterativeMergeSort {
	public IterativeMergeSort() {}
	
	public void sort(int[] array) {
		if(array == null) return ;
		if(array.length > 1) {
			int m = array.length/2;
			int[] left = new int[m];
			int[] right = new int[array.length - m];
			
			for(int i=0; i<m; i++) left[i] = array[i];
			for(int i=0; i<right.length; i++) right[i] = array[m+i];
			sort(left);
			sort(right);
			
			int i=0, j=0, k=0;
			while(i<left.length && j<right.length) {
				if(left[i] < right[j]) array[k++] = left[i++];
				else array[k++] = right[j++];
			}
			while(i<left.length) array[k++] = left[i++];
			while(j<right.length) array[k++] = right[j++]; 
		}
	}
}
