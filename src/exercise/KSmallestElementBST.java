package exercise;

import java.util.Stack;

import exercise.FlattenBinaryTree.TreeNode;

public class KSmallestElementBST {
    public static int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(!stack.isEmpty() || root != null) {
        	while(root != null) {
        		stack.push(root);
        		root = root.left;
        	}
        	
        	root = stack.pop();
        	if(--k == 0) break;
        	root = root.right;
        }
        return root.val;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
