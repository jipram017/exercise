package coding_preps;

public class QuickSort {
	// Time complexity O(NlogN) on average
	// Space complexity O(logN)
	public static int[] sortArray(int[] array) {
		quickSort(array, 0, array.length-1);
		return array;
	}
	
	public static void quickSort(int[] array, int start, int end) {
		int pivot = array[end];
		int low = start - 1;
		
		for(int i=start; i<end; i++) {
			if(array[i] < pivot) {
				low++;
				int temp = array[low];
				array[low] = array[i];
				array[i] = temp;
			}
		}
		
		int temp = array[low+1];
		array[low+1] = pivot;
		array[end] = temp;
		
		if(low>start) {
			quickSort(array, start, low);
		}
		if((low+2)<end) {
			quickSort(array, low+2, end);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
