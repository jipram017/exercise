package exercise;

import java.util.HashMap;

import exercise.FlattenBinaryTree.TreeNode;

//Construct Binary Tree Given Postorder and Inorder Array
public class ConstructBinaryTreeII {
	
	HashMap<Integer, Integer> map = new HashMap<>();
	int[] inorder;
	int[] postorder;
	int post_index;
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        post_index = postorder.length - 1;
        
        int index = 0;
        for(Integer in : inorder) {
        	map.put(in, index++);
        }
        return buildTreeHelper(0, inorder.length-1);
    }
    
    public TreeNode buildTreeHelper(int minVal, int maxVal) {
    	if(minVal > maxVal) return null;
    	int val = postorder[post_index];
    	TreeNode root = new TreeNode(val);
    	
    	int currentIdx = map.get(val);
    	
    	post_index--;
    	root.right = buildTreeHelper(currentIdx+1, maxVal);
    	root.left = buildTreeHelper(minVal, currentIdx-1);
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
