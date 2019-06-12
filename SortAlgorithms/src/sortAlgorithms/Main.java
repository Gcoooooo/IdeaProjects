package sortAlgorithms;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) {
		int[] nums = {4,4,3,5,1,2,9,0};
		
		SelectionSortClass selectionSort = new SelectionSortClass();
		InsertionSortClass insertionSort = new InsertionSortClass();
		MergeSortClass mergeSort = new MergeSortClass();
		QuickSortClass quickSort = new QuickSortClass();
		
//		selectionSort.selectionSort(nums);
//		insertionSort.insertionSort(nums);
//		mergeSort.mergeSort(nums);
		quickSort.quickSort(nums);

		LinkedList
		
		for (int n : nums) {
			System.out.println(n);
		}
	}

}
