package exercises;

public class SameBST {
	// Time complexity O(n^2)
	// Space complexity O(d) where d is depth of BST
	public static boolean areSameBSTs(int[]array1, int[]array2) {
		if(array1.length != array2.length)return false;
		return areSameBSTArrays(array1, array2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean areSameBSTArrays(int[] array1, int[] array2, 
			                                int rootIdxOne, int rootIdxTwo,
			                                int minVal, int maxVal) {
		if(rootIdxOne == -1 && rootIdxTwo == -1) return rootIdxOne == rootIdxTwo;
		if(array1[rootIdxOne] != array2[rootIdxTwo]) return false;
		
		int leftRootIdxOne = getIdxOfFirstSmaller(array1, rootIdxOne, minVal);
		int leftRootIdxTwo = getIdxOfFirstSmaller(array2, rootIdxTwo, minVal);
		
		int rightRootIdxOne = getIdxOfFirstBiggerOrEqual(array1, rootIdxOne, maxVal);
		int rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(array2, rootIdxTwo, maxVal);
		
		boolean leftAreSame = areSameBSTArrays(array1,array2, leftRootIdxOne, leftRootIdxTwo, minVal, array1[rootIdxOne]);
		boolean rightAreSame = areSameBSTArrays(array1, array2, rightRootIdxOne, rightRootIdxTwo, array1[rootIdxOne], maxVal);
		return leftAreSame && rightAreSame;
	}
	
	public static int getIdxOfFirstSmaller(int[] array, int rootIdx, int minVal) {
		for(int i = rootIdx+1; i < array.length; i++) {
			if(array[i] < array[rootIdx] && array[i] >= minVal) {
				return i;
			}
		}
		return -1;
	}
	
	public static int getIdxOfFirstBiggerOrEqual(int[] array, int rootIdx, int maxVal) {
		for(int i = rootIdx+1; i < array.length; i++) {
			if(array[i] >= array[rootIdx] && array[i] < maxVal) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array1 = {10,15,8,12,94,81,5,2,11};
		int[] array2 = {10,8,5,15,2,12,11,94,81};
		System.out.println(areSameBSTs(array1, array2));
	}

}
