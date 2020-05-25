package exercise;

import exercise.FlattenBinaryTree.TreeNode;

public class PathSum {
	/** Determine if a tree has at least one root-to-leaf path that summed up to sum **/
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return dfs1(root, sum);
    }
    
    public static boolean dfs1(TreeNode root, int sum) {
    	if(root == null) return false;
        if(root.val == sum && root.left == null && root.right == null) return true;
    	boolean leftSum = dfs1(root.left, sum - root.val);
    	boolean rightSum = dfs1(root.right, sum - root.val);
    	return leftSum || rightSum;
    }
    
    
    /** Determine total number of paths in a tree that the values are summed up to sum **/
    static int count = 0;
    public static int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        dfs3(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }
    
    public static void dfs3(TreeNode root, int sum) {
    	if(root == null) return;
        if(root.val == sum) {
        	count++;
        };
    	dfs3(root.left, sum - root.val);
    	dfs3(root.right, sum - root.val);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
