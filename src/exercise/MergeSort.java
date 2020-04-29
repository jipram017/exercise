package exercise;

import java.util.Arrays;

// O(n log(n)) time
// O(n log(n)) space
public class MergeSort {
	public static int[] mergeSort(int[] array) {
		if(array.length == 1) {
			return array;
		}
		
		int middleIdx = array.length / 2;
		int[] leftArray = Arrays.copyOfRange(array, 0, middleIdx);
		int[] rightArray = Arrays.copyOfRange(array, middleIdx, array.length);
		
		return doMerge(mergeSort(leftArray), mergeSort(rightArray));
	}
	
	public static int[] doMerge(int[] array1, int[] array2) {
		int[] array3 = new int[array1.length + array2.length];
		int i=0, j=0, k=0;
		while(i < array1.length && j < array2.length) {
			if(array1[i] < array2[j]) {
				array3[k] = array1[i];
				i++;
			} else {
				array3[k] = array2[j];
				j++;
			}
			k++;
		}
		
		while(i < array1.length) {
			array3[k] = array1[i];
			i++; k++;
		}
		while(j < array2.length) {
			array3[k] = array2[j];
			j++; k++;
		}
		return array3;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {8,5,2,9,5,6,3};
		int[] result = mergeSort(array);
		for(int n : result) {
			System.out.println(n);
		}
	}
}
