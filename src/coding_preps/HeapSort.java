package coding_preps;

public class HeapSort {
	// Time complexity O(NlogN)
	// Space complexity O(N) --> to build max heap
	public static int[] sortArray(int[] array) {
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
	
	public static void swap(int[] array, int idx1, int idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
