package exercise;

import java.util.HashMap;
import exercise.FlattenBinaryTree.TreeNode;

// Construct Binary Tree Given Preorder and Inorder Array
public class ConstructBinaryTreeI {
	
	HashMap<Integer, Integer> map = new HashMap<>();
	int[] preorder, inorder;
	int pre_index  = 0;
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0) return null;
    	this.preorder = preorder;
    	this.inorder= inorder;
    	
        int index  = 0;
    	for(Integer in : inorder) {
    		map.put(in, index++);
    	}
    
    	return buildTreeHelper(0, inorder.length);
    }
    
    public TreeNode buildTreeHelper(int minVal, int maxVal) {
    	if(minVal == maxVal) return null;
    	int val = preorder[pre_index];
    	TreeNode root = new TreeNode(val);
    	
    	int currentIdx = map.get(val);
    	
    	pre_index++;
    	root.left = buildTreeHelper(minVal, currentIdx);
    	root.right = buildTreeHelper(currentIdx+1, maxVal);
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
