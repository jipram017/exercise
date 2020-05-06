package exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import exercise.FlattenBinaryTree.TreeNode;

public class BinaryTreeTraversal {
	public Stack<TreeNode> stack = new Stack<TreeNode>();
	public List<Integer> result = new ArrayList<Integer>();
	public LinkedList<Integer> order = new LinkedList<Integer>();
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
        	if(current != null) {
        		stack.push(current);
        		current = current.left;
        	} else {
        		TreeNode node = stack.pop();
        		result.add(node.val);
        		current = node.right;
        	}
        }
        return result;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
    	if(root ==null) return result;
    	stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	result.add(node.val);
        	if(node.right != null) {
        		stack.push(node.right);
        	}
           	if(node.left != null) {
        		stack.push(node.left);
        	}
        }
        return result;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
    	if(root == null) return order;
    	stack.push(root);
    	while(!stack.isEmpty()) {
    		TreeNode current = stack.pop();
    		if(current.left != null) {
    			stack.push(current.left);
    		}
    		if(current.right != null) {
    			stack.push(current.right);
    		}
    		order.addFirst(current.val);
    	}
        return order;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
