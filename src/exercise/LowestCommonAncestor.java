package exercise;

import exercise.FlattenBinaryTree.TreeNode;

public class LowestCommonAncestor {
	
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null) return null;
    	if(root == p || root == q) return root;
    	
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	
    	if(left != null && right != null) return root;
    	if(left != null || right != null) return left == null? right : left;
    	return null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
