package coding_preps;

import helper.DataStructure.TreeNode;

/** LeetCode #114 **/
public class FlattenBinaryTree {
	
	// This approach does not use additional data structure
	// Time complexity O(N)
	// Space complexity O(NlogN)
	// where N is the number of nodes
	static TreeNode prev = null;
	public static void flatten(TreeNode root) {
		if(root==null) return;
		
		flatten(root.right);
		flatten(root.left);
		
		root.left = null;
		root.right = prev;
		prev = root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
