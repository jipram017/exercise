package coding_preps;

import helper.DataStructure.TreeNode;

/**LeetCode #104, #111 **/
public class MaxMinDepth {
	// Time complexity O(N)
	// Space complexity O(NlogN)
	// where N is the number of nodes
	
	public static int maxDepth(TreeNode root) {
		if(root==null) return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
    public static int minDepth(TreeNode root) {
    	if(root==null) return 0;
    	if(root.left == null) return 1 + minDepth(root.right);
    	if(root.right == null) return 1 + minDepth(root.left);
    	return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
