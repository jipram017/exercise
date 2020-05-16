package exercise;

public class SortingAlgorithm {
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
	
	public static int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		
		for(int i = start; i < end; i++) {
			if(nums[i] < pivot) {
                int temp= nums[start];
                nums[start]=nums[i];
                nums[i]=temp;
				start++;
			}
		}
		
	    int temp = nums[start];
	    nums[start] = pivot;
	    nums[end] = temp;
		return start;
	}
	
	public static void heapSort(int[] array) {
		MaxHeap.buildMaxHeap(array);
		int j = array.length-1;
		while(j > 0) {
			swap(0, j, array);
			MaxHeap.siftDown(0, --j, array);
		}
	}
	
	public static void swap(int x, int y, int[] nums) {
        nums[x] = nums[x] * nums[y]; // nums[x] now becomes nums[x]*nums[y]
        nums[y] = nums[x] / nums[y]; // nums[y] now becomes nums[x] 
        nums[x] = nums[x] / nums[y]; // nums[x] now becomes nums[y]
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {8,5,2,9,5,6,3};
		heapSort(nums);
		for(int num : nums) {
			System.out.print(" " + num);
		}
	}

}
