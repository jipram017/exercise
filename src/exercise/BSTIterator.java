package exercise;

import java.util.Stack;

import exercise.FlattenBinaryTree.TreeNode;

public class BSTIterator {
	
	static Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root != null) {
        	stack.push(root);
        	root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public static int next() {
        TreeNode root = stack.pop();
        Integer value = root.val;
        if(root.right!= null) {
        	root = root.right;
        	while(root != null) {
        		stack.push(root);
        		root = root.left;
        	}
        }
        return value;
    }
    
    /** @return whether we have a next smallest number */
    public static boolean hasNext() {
        return !stack.isEmpty();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
