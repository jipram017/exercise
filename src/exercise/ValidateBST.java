package exercise;

import exercise.FlattenBinaryTree.TreeNode;

public class ValidateBST {
	public static boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isValidBSTHelper(TreeNode root, int min, int max) {
		if(root == null) return false;
		if(min > root.val || max < root.val)return false;
		return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
