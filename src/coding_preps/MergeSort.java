package coding_preps;

import java.util.Arrays;

public class MergeSort {

	/** LeetCode #912 **/
	/** MergeSort **/
	// Time complexity O(NlogN)
	// Space complexity O(NlogN)
	public static int[] sortArray(int[] array) {
		if(array==null || array.length<=1) return array;
		
		int midIdx = (0 + array.length)/2;
		int[] leftArray = Arrays.copyOfRange(array, 0, midIdx);
		int[] rightArray = Arrays.copyOfRange(array, midIdx, array.length);
		return doMerge(sortArray(leftArray), sortArray(rightArray));
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
