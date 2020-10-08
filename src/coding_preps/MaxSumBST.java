package coding_preps;

import helper.DataStructure.TreeNode;

/** LeetCode #1373 **/
public class MaxSumBST {
	
	// Time complexity O(N)
	// Space complexity O(NlogN)
	// where N is the number of nodes
	
	private static int max;
	public static int maxSumBST(TreeNode root) {
		maxSumBSTHelper(root);
		return max;
	}
	
	// this function return an array with elements {currentSum, maxVal, minVal, isBST}
	public static int[] maxSumBSTHelper(TreeNode root) {
		if(root==null) return null;
		int[] left = maxSumBSTHelper(root.left);
		int[] right = maxSumBSTHelper(root.right);
		
		if(left!= null && (left[1] >= root.val || left[3] == 0)) {
			return new int[] {0,-1,-1,0};
		}
		
		if(right!= null && (right[2] < root.val || right[3] == 0)) {
			return new int[] {0,-1,-1,0};
		}
		
		int leftSum = left == null? 0 : left[0];
		int rightSum = right == null? 0 : right[0];
		int currentSum = leftSum + rightSum + root.val;
		max = Math.max(max, currentSum);
		
		int minVal = left == null? root.val : left[1];
		int maxVal = right == null? root.val : right[2];
		return new int[] {currentSum, maxVal, minVal, 1};
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
