package coding_preps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	// Time complexity O(NlogK) where N is total number of elements and K is array size
	// Space complexity O(N)
	public static int[] mergeKSortedArray(int[][] arr) {
		if(arr == null || arr.length == 0) return null;
		
		class ArrayContainer implements Comparable<ArrayContainer>{
			private int index;
			private int[] arr;
			
			public ArrayContainer(int[] arr, int index) {
				this.index = index;
				this.arr = arr;
			}
			
			@Override
			public int compareTo(ArrayContainer arg0) {
				// TODO Auto-generated method stub
				return this.arr[this.index]- arg0.arr[arg0.index] ;
			}	
		}
		
		PriorityQueue<ArrayContainer> q = new PriorityQueue<ArrayContainer>();
		int total = 0;
		for(int[] ar : arr) {
			if(ar != null) q.offer(new ArrayContainer(ar, 0));
			total += ar.length;
		}
		
		int[] result = new int[total];
		int k = 0;
		while(!q.isEmpty()) {
			ArrayContainer top = q.poll();
			result[k++] = top.arr[top.index];
			if(top.index < top.arr.length-1) {
				q.offer(new ArrayContainer(top.arr, top.index+1));
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
 
		int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));
	}

}
