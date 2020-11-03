package coding_preps;

import java.util.Arrays;

public class MinHeap {
	// Time complexity O(N)
	// Space complexity O(1)
	public static void buildMinHeap(int[] arr) {
		int firstParentIdx = (arr.length-2)/2;
		for(int i=firstParentIdx; i>=0; i--) {
			shiftDown(arr, i, arr.length-1);
		}
	}
	
	// Time complexity O(logN)
	// Space complexity O(1) 
	public static void shiftUp(int[] result, int start) {
		int parentIdx = (start-1)/2;
		while(parentIdx >= 0 && result[parentIdx] > result[start]) {
			swap(result, start, parentIdx);
			start = parentIdx;
			parentIdx = (start-1)/2;
		}
	}
	
	// Time complexity O(logN)
	// Space complexity O(1) 
	public static void shiftDown(int[] result, int start, int end) {
		int idxOne = 2*start + 1;
		while(idxOne <= end) {
			int idxToSwap = idxOne;
			int idxTwo = (2*start + 2 <= end) ? 2*start + 2 : -1;
			if(idxTwo != -1 && result[idxOne] > result[idxTwo]) {
				idxToSwap = idxTwo;
			}
			if(result[idxToSwap] < result[start]) {
				swap(result, start, idxToSwap);
				start = idxToSwap;
				idxOne = 2*start+1;
			} else {
				break;
			}
		}
	}
	
	// Time complexity O(logN)
	// Space complexity O(N) since we create additional array
	public static int[] insert(int[] arr, int value) {
		int[] result = Arrays.copyOfRange(arr, 0, arr.length+1);
		result[result.length-1] = value;
		shiftUp(result, result.length-1);
		return result;
	}
	
	// Time complexity O(logN)
	// Space complexity O(N) since we create additional array
	public static int[] remove(int[] arr) {
		swap(arr, 0, arr.length-1);
		int[] result = Arrays.copyOfRange(arr, 0, arr.length-1);
		shiftDown(result, 0, result.length-1);
		return result;
	}
	
	private static void swap(int[] arr, int idx1, int idx2) {
		arr[idx1] = arr[idx1]*arr[idx2];
		arr[idx2] = arr[idx1] / arr[idx2];
		arr[idx1] = arr[idx1] / arr[idx2];
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {31,9,23,17,12,30,44,102,18};
		buildMinHeap(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		int[] result1 = remove(nums);
		for(int num : result1) {
			System.out.print(num + " "); 
		}
		  
		System.out.println();
		int[] result2 = insert(result1, 9);
		for(int num : result2) {
			System.out.print(num + " ");
		}
	}

}
