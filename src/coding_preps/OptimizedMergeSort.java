package coding_preps;

import java.util.Arrays;

/** LeetCode #912 **/
/** Space-optimized merge sort **/
public class OptimizedMergeSort {
	// Time complexity O(NlogN)
	// Space complexity O(N)
	public static int[] sortArray(int[] array) {
		if(array.length <= 1) return array;
		int[] auxArray = Arrays.copyOf(array, array.length);
		
		mergeSortHelper(0, array.length-1, auxArray, array);
		return array;
	}
	
	public static void mergeSortHelper(int startIdx, int endIdx, int[] auxArray, int[] array) {
		if(startIdx==endIdx) {
			return;
		}
		int midIdx = (startIdx+endIdx)/2;
		mergeSortHelper(startIdx, midIdx, array, auxArray);
		mergeSortHelper(midIdx+1, endIdx, array, auxArray);
		doMerge(startIdx, midIdx, endIdx, auxArray, array);
	}
	
	public static void doMerge(int startIdx, int midIdx, int endIdx, int[] array, int[] auxArray) {
		int i=startIdx;
		int j=midIdx;
		int k=i;
		
		while(i<=midIdx && j<=endIdx) {
			if(auxArray[i] < auxArray[j]) {
				array[k] = auxArray[i];
				i++;
			} else {
				array[k] = auxArray[j];
				j++;
			}
			k++;
		}
		
		while(i<=midIdx) {
			array[k] = auxArray[i];
			i++; k++;
		}
		while(j<=endIdx) {
			array[k] = auxArray[j];
			j++; k++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
