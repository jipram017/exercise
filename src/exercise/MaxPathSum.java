package exercise;

public class MaxPathSum {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	}
	
	public static int maxPathSum = Integer.MIN_VALUE;
	public static int maxPathSum(TreeNode root) {
		if( root == null) return 0;
		maxPathSum2(root);
		return maxPathSum;
	}
	public static int maxPathSum2(TreeNode root) {
		if (root == null) return 0;
		int leftMaxSumAsBranch = maxPathSum2(root.left);
		int rightMaxSumAsBranch = maxPathSum2(root.right);
		int maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
		
		int maxSumAsBranch = Math.max(root.val, root.val + maxChildSumAsBranch);
		int maxSumAsRoot = Math.max(leftMaxSumAsBranch + root.val + rightMaxSumAsBranch, maxSumAsBranch);
		if(maxSumAsRoot >= maxPathSum) {
			maxPathSum = maxSumAsRoot;
		}
		
		return maxSumAsBranch;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
