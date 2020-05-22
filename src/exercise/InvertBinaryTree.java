package exercise;

import java.util.LinkedList;
import java.util.Queue;

import exercise.FlattenBinaryTree.TreeNode;

public class InvertBinaryTree {
	// Time complexity O(N), space complexity O(H) 
	// Recursive approach
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode leftRoot = invertTree(root.left);
        TreeNode rightRoot = invertTree(root.right);
        
        root.left = rightRoot;
        root.right = leftRoot;
        return root;
    }
    
    // Time complexity O(N), space complexity O(H) 
    // Using queue
    public static TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	TreeNode node = q.poll();
        	TreeNode temp = node.left;
        	node.left = node.right;
        	node.right = temp;
        	if(node.left != null) q.offer(node.left);
        	if(node.right != null) q.offer(node.right);
        }
        return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
