package sorting;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,8,3,0,1,2,0,2,1};
		//BubbleSort bubbleSort = new BubbleSort();
		//bubbleSort.sort(array);
		//RecursiveBubbleSort recursiveBubbleSort = new RecursiveBubbleSort();
		//recursiveBubbleSort.sort(array, array.length);
		//SelectionSort selectionSort = new SelectionSort();
		//selectionSort.sort(array);
		//InsertionSort insertionSort = new InsertionSort();
		//insertionSort.sort(array);
		//RecursiveInsertionSort recursiveInsertionSort = new RecursiveInsertionSort();
		//recursiveInsertionSort.sort(array, array.length);
		//MergeSort mergeSort = new MergeSort();
		//mergeSort.sort(array, 0, array.length-1);
		//IterativeMergeSort iterativeMergeSort = new IterativeMergeSort();
		//iterativeMergeSort.sort(array);
		//QuickSort quickSort = new QuickSort();
		//quickSort.sort(array, 0, array.length-1);
		//HeapSort heapSort = new HeapSort();
		//heapSort.sort(array);
		ShellSort shellSort = new ShellSort();
		shellSort.sort(array);
		for(int val:array) System.out.println(val);
		
	}

}
