package exercise;

import java.util.Arrays;

public class SortingAlgorithm {
	// Time complexity O(N^N), space complexity O(1)
	public static int[] bubbleSort(int[] nums) {
		boolean isSorted = false;
		int counter = 0;
		while(!isSorted) {
			isSorted = true;
			for(int i = 0; i < nums.length-1-counter; i++) {
				if(nums[i] > nums[i+1]) {
					swap(i, i+1, nums);
					isSorted = false;
				}
			}
			counter++;
		}
		return nums;
	}
	
	// Time complexity O(N^N), space complexity O(1)
	public static int[] insertionSort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			int j = i;
			while(j>0) {
				if(nums[j] < nums[j-1]) {
					swap(j,j-1,nums);
				}
				j--;
			}
		}
		return nums;
	}
	
	// Time complexity O(N^N), space complexity O(1)
	public static int[] selectionSort(int[] nums) {
		int currentIdx = 0;
		while(currentIdx < nums.length-1) {
			int smallestIdx = currentIdx;
			for(int i=currentIdx+1; i < nums.length; ++i) {
				if(nums[i] <= nums[smallestIdx]) {
					smallestIdx = i;
				}
			}
			swap(currentIdx, smallestIdx, nums);
			currentIdx++;
		}
		return nums;
	}
	
	// Time complexity O(N log(N)), space complexity O(log N)
	public static int[] quickSort(int[] nums) {
		quickSortHelper(nums, 0, nums.length-1);
		return nums;
	}
	
	public static void quickSortHelper(int[] nums, int start, int end) {
		int pivot = nums[end];
		int low = start - 1;
		
		for(int i = start; i < end; i++) {
			if(nums[i] < pivot) {
				low++;
                int temp= nums[low];
                nums[low]=nums[i];
                nums[i]=temp;
			}
		}
		
	    int temp = nums[low+1];
	    nums[low+1] = pivot;
	    nums[end] = temp;

	    if(low>start) {
	    	quickSortHelper(nums, start, low);
	    }
	    if(low+2<end) {
	        quickSortHelper(nums, low + 2, end);
	    }
	}
	
	// Time complexity O(N), space complexity O(1)
	public static void heapSort(int[] array) {
		MaxHeap.buildMaxHeap(array);
		int j = array.length-1;
		while(j > 0) {
			swap(0, j, array);
			MaxHeap.siftDown(0, --j, array);
		}
	}
	
	
	// Time complexity O(N log(N)), space complexity O(N log(N)) where N = input array size
	public static int[] mergeSort(int[] array) {
		if(array.length == 1) return array;
		int middleIdx = array.length/2;
		int[] leftArray = Arrays.copyOfRange(array, 0, middleIdx);
		int[] rightArray = Arrays.copyOfRange(array, middleIdx, array.length);
		
		return doMerge(mergeSort(leftArray), mergeSort(rightArray));
	}
	
	public static int[] doMerge(int[] left, int[]right) {
		int[] result = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				result[k] = left[i];
				i++;
			} else {
				result[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i < left.length) {
			result[k] = left[i];
			i++; k++;
		}
		while(j < right.length) {
			result[k] = right[j];
			j++; k++;
		}
		
		return result;
	}
	
	public static void swap(int x, int y, int[] nums) {
        nums[x] = nums[x] * nums[y]; // nums[x] now becomes nums[x]*nums[y]
        nums[y] = nums[x] / nums[y]; // nums[y] now becomes nums[x] 
        nums[x] = nums[x] / nums[y]; // nums[x] now becomes nums[y]
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {8,5,2,9,5,6,3};
		int[] result = mergeSort(nums);
		for(int num : result) {
			System.out.print(" " + num);
		}
	}

}
