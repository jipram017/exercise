package exercises;

import helper.DataStructure.TreeNode;

public class DeleteLeaves {
	public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
		root.left = removeLeafNodes(root.left, target);
		root.right = removeLeafNodes(root.right, target);
        if(root.left == null && root.right == null && root.val == target) {
		    return null;
		}
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
