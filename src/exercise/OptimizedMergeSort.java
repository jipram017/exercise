package exercise;

//O(n log (n)) time
//O(n) space
public class OptimizedMergeSort {
	public static int[] sortArray(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		
		int[] auxiliary = array.clone();
		mergeSortHelper(array, auxiliary, 0, array.length-1);
		return array;
	}
	
	public static void mergeSortHelper(int[] array, int[] auxiliary, int start, int end) {
		if(start == end) {
			return;
		}
		
		int middleIdx = (start + end)/2;
		mergeSortHelper(auxiliary, array, start, middleIdx);
		mergeSortHelper(auxiliary, array, middleIdx+1, end);
		doMerge(array, start, middleIdx, end, auxiliary);
	}
	
	public static void doMerge(int[] array, int start, int middle, int end, int[] auxiliary) {
		int k = start;
		int i = start;
		int j = middle+1;
		
		while(i <= middle && j <= end) {
			if(auxiliary[i] <= auxiliary[j]) {
				array[k] = auxiliary[i];
				i++;
			} else {
				array[k] = auxiliary[j];
				j++;
			}
			k++;
		}
		
		while(i <= middle) {
			array[k] = auxiliary[i];
			i++; k++;
		}
		while(j <= end) {
			array[k] = auxiliary[j];
			j++; k++;
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {8,5,2,9,5,6,3};
		int[] result = sortArray(array);
		for(int n : result) {
			System.out.println(n);
		}
	}
}
