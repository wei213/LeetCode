package sorting;

public class MergeSort {
	public MergeSort() {}
	//MergeSort mergeSort = new MergeSort();
	//mergeSort.sort(array, 0, array.length-1);
	public void sort(int[] array, int l, int h) {
		if(l < h) {
			int m = (l + h)/2;
			sort(array, l, m);
			sort(array, m+1, h);
			merge(array, l, m, h);
		}
	}
	
	private static void merge(int[] array, int l, int m, int h) {
		int n1 = m-l+1;
		int n2 = h-m;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i=0; i<n1; i++) left[i] = array[l+i];
		for(int j=0; j<n2; j++) right[j] = array[m+j+1];
		
		int k=l;
		int i=0, j=0;
		while(i<n1 && j<n2) {
			if(left[i] < right[j]) array[k++] = left[i++];
			else  array[k++] = right[j++];
		}
		while(i<n1) array[k++] = left[i++];
		while(j<n2) array[k++] = right[j++];
	}
}
