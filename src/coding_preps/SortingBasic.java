package coding_preps;

import java.util.Arrays;

public class SortingBasic {
	// Time complexity O(N^2)
	// Space complexity O(1)
	public static int[] bubbleSort(int[] array) {
		if(array==null || array.length==0) return array;
		boolean isSorted = false;
		int counter = 0;
		while(!isSorted) {
			isSorted = true;
			for(int i=0; i<array.length-1-counter; i++) {
				if(array[i]>array[i+1]) {
					swap(array, i, i+1);
					isSorted = false;
				}
			}
			counter++;
		}
		return array;
	}
	
	// Time complexity O(N^2)
	// Space complexity O(1)
	public static int[] selectionSort(int[] array) {
		if(array==null || array.length==0) return array;
		for(int i=0; i<array.length-1; i++) {
			int minIdx = i;
			for(int j=i+1; j<=array.length; j++) {
				if(array[j] < array[i]) {
					minIdx = j;
				}
			}
			swap(array, i, minIdx);
		}
		return array;
	}
	
	// Time complexity O(N^2)
	// Space complexity O(1)
	public static int[] insertionSort(int[] array) {
		if(array==null || array.length==0) return array;
		for(int i=1; i<array.length; i++) {
			int j = i;
			while(j>0) {
				if(array[j-1] > array[j]) {
					swap(array, j, j-1);
				}
				j--;
			}
		}
		return array;
	}
	
	// Time complexity O(NlogN) on average
	// Space complexity O(logN)
	public static int[] quickSort(int[] array) {
		quickSort(array, 0, array.length-1);
		return array;
	}
	
	public static void quickSort(int[] array, int start, int end) {
		int pivot = array[end];
		int low = start - 1;
		
		for(int i=start; i<end; i++) {
			if(array[i] < pivot) {
				low++;
				swap(array, low, i);
			}
		}
		
		swap(array, low+1, end);
		
		if(low>start) {
			quickSort(array, start, low);
		}
		if((low+2)<end) {
			quickSort(array, low+2, end);
		}
	}
	
	// Time complexity O(NlogN)
	// Space complexity O(NlogN)
	public static int[] mergeSort(int[] array) {
		if(array==null || array.length<=1) return array;
		
		int midIdx = (0 + array.length)/2;
		int[] leftArray = Arrays.copyOfRange(array, 0, midIdx);
		int[] rightArray = Arrays.copyOfRange(array, midIdx, array.length);
		return doMerge(mergeSort(leftArray), mergeSort(rightArray));
	}
	
	public static int[] doMerge(int[] leftArr, int[] rightArr) {
		int i=0, j=0, k=0;
		int[] result = new int[leftArr.length+rightArr.length];
		
		while(i<leftArr.length && j<rightArr.length) {
			if(leftArr[i] < rightArr[j]) {
				result[k] = leftArr[i];
				i++;
			} else {
				result[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i<leftArr.length) {
			result[k] = leftArr[i];
			i++; k++;
		}
		
		while(j<rightArr.length) {
			result[k] = leftArr[j];
			j++; k++;
		}
		
		return result;
	}
	
	// Time complexity O(NlogN)
	// Space complexity O(N) --> to build max heap
	public static int[] heapSort(int[] array) {
		buildMaxHeap(array);
		for(int i=array.length-1; i>=0; i--) {
			swap(array, 0, i);
			shiftDown(0, i-1, array);
		}
		return array;
	}
	
	public static void buildMaxHeap(int[] array) {
		int firstParentIdx = (array.length-2)/2;
		for(int i=firstParentIdx; i>=0; i--) {
			shiftDown(i, array.length-1, array);
		}
	}
	
	public static void shiftDown(int startIdx, int endIdx, int[] array) {
		int childOneIdx = 2*startIdx + 1;
		while(childOneIdx <= endIdx) {
			int idxToSwap = childOneIdx;
			int childTwoIdx = (2*startIdx + 2) <= endIdx? (2*startIdx + 2):-1;
			if(childTwoIdx != -1 && array[childTwoIdx] > array[childOneIdx]) {
				idxToSwap = childTwoIdx;
			}
			if(array[idxToSwap] > array[startIdx]) {
				swap(array, idxToSwap, startIdx);
				startIdx = idxToSwap;
				childOneIdx = 2*startIdx + 1;
			} else {
				break;
			}
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
