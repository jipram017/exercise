package exercise;

import exercise.FlattenBinaryTree.TreeNode;

public class SecondMinimumNodeBinaryTree {
	   static int min;
	   static long ans = Long.MAX_VALUE;
	   public static int findSecondMinimumValue(TreeNode root) {
	    	if(root==null) return -1;
	    	min = root.val;
	    	dfs(root);
	    	return ans < Long.MAX_VALUE ? (int) ans : -1;
	    }
	    
	    public static void dfs(TreeNode root) {
	    	if(root != null) {
	    		if(min == root.val) {
	    			dfs(root.left);
	    			dfs(root.right);
	    		} else if(min < root.val && root.val < ans) {
	    			ans = root.val;
	    		}
	    	}
	    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
