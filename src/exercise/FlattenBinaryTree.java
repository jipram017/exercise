package exercise;

import java.util.Stack;

public class FlattenBinaryTree {
	// Definition for a binary tree node.
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
	
	// This approach uses stack as helper data structure
    public static void flatten(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	while(!stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		if (node.right != null) {
    			stack.push(node.right);
    		}
    		if (node.left != null) {
    			stack.push(node.left);
    		}
    		if(!stack.isEmpty()) {
    			node.right = stack.peek();
    		}
    		node.left = null;
    	}
	}
    
    // This approach does not use additional data structure
    private TreeNode prev = null;
    public void flatten2(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	
    	flatten2(root.right);
    	flatten2(root.left);
    	
    	root.left = null;
    	root.right = prev;
    	prev = root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
