package coding_preps;

import helper.DataStructure.TreeNode;

/** LeetCode #124 **/
public class MaxPathSum {
	
	// Time complexity O(N) 
	// Space complexity O(NlogN) 
	// where N is the number of nodes
	static int maxPathSum = Integer.MIN_VALUE;
	public static int maxPathSum(TreeNode root) {
		if(root==null) return 0;
		maxPathSumHelper(root);
		return maxPathSum;
	}
	
	public static int maxPathSumHelper(TreeNode root) {
		if(root==null) return 0;
		int leftPathSumAsBranch = maxPathSumHelper(root.left);
		int rightPathSumAsBranch = maxPathSumHelper(root.right);
		int maxChildSumAsBranch = Math.max(rightPathSumAsBranch, leftPathSumAsBranch);
		int maxSumAsBranch = Math.max(maxChildSumAsBranch + root.val, root.val);
		int maxSumAsRoot = Math.max(maxSumAsBranch, leftPathSumAsBranch + root.val + rightPathSumAsBranch);
		maxPathSum = Math.max(maxPathSum, maxSumAsRoot);
		return maxSumAsBranch;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
