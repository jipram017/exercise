package coding_preps;

import helper.DataStructure.TreeNode;

/** LeetCode #98 **/
public class ValidateBST {
	// Time complexity O(N) where N is the number of nodes
	// Space complexity O(h) where h is the height of BST
	public static boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public static boolean isValidBSTHelper(TreeNode root, long minVal, long maxVal) {
        if(root==null) return true;
		if(root.val <= minVal || root.val >= maxVal) {
			return false;
		}
		
		boolean isLeftValid = isValidBSTHelper(root.left, minVal, root.val);
		boolean isRightValid = isValidBSTHelper(root.right, root.val, maxVal);
		
		if(!isLeftValid || !isRightValid) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
