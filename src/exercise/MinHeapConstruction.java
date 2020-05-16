package exercise;

import java.util.Arrays;

public class MinHeapConstruction {
	// Time complexity O(N) since we use shift down method, space complexity O(1)
	public static void buildHeap(int[] array) {
		int firstParentIdx = (array.length-2)/2;
		for(int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
			siftDown(currentIdx, array.length-1, array);
		}
	}
	
	// Time complexity O(log N), space complexity O(1)
	public static void siftUp(int currentIdx, int[] array) {
		int parentIdx = (currentIdx-1)/2;
		while (currentIdx > 0 && array[currentIdx] < array[parentIdx]) {
			swap(currentIdx, parentIdx, array);
			currentIdx = parentIdx;
			parentIdx = (currentIdx-1)/2;
		}
	}
	
	// Time complexity O(log N), space complexity O(1)
	public static void siftDown(int currentIdx, int endIdx, int[] array) {
		int childOneIdx = 2*currentIdx + 1;
		while(childOneIdx <= endIdx) {
			int idxToSwap = childOneIdx;
			int childTwoIdx = (2*currentIdx+2) <= endIdx? 2*currentIdx+2 : -1;
			if(childTwoIdx != -1 && array[childTwoIdx] < array[childOneIdx]) {
				idxToSwap = childTwoIdx;
			} 
			if(array[idxToSwap] < array[currentIdx]) {
				swap(idxToSwap, currentIdx, array);
				currentIdx = idxToSwap;
				childOneIdx = 2*currentIdx + 1;
			} else {
				break;
			}
		}
	}
	
	// Time complexity O(log N), space complexity O(N) since we create additional array
	public static int[] insert(int value, int[] array) {
		int[] result = Arrays.copyOf(array, array.length+1);
		result[result.length-1] = value;
		siftUp(result.length-1, result);
		return result;
	}

	// Time complexity O(log N), space complexity O(N) since we create additional array
	public static int[] remove(int[] array) {
		swap(0, array.length-1, array);
		int[] result = Arrays.copyOfRange(array, 0, array.length-1);
		siftDown(0, result.length-1, result);
		return result;
	}
	
	public static void swap(int idxOne, int idxTwo, int[] array) {
		array[idxOne] = array[idxOne]*array[idxTwo];
		array[idxTwo] = array[idxOne]/array[idxTwo];
		array[idxOne] = array[idxOne]/array[idxTwo];
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {31,9,23,17,12,30,44,102,18};
		buildHeap(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
		int[] result1 = remove(nums);
		for(int num : result1) {
			System.out.print(num + " ");
		}
		System.out.println(); 
		int[] result2 = insert(9, result1);
		for(int num : result2) {
			System.out.print(num + " ");
		}		
	}

}
