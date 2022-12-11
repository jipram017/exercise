package exercise;

import exercise.FlattenBinaryTree.TreeNode;

public class BSTFromPreorder {
    // Construct BST from Preorder Array
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return null;
        return buildBSTHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode buildBSTHelper(int[] preorder, int minVal, int maxVal) {
    	if(index >= preorder.length) return null;
    	int root_val = preorder[index];
    	TreeNode root = null;
    	
    	if(root_val > minVal && root_val < maxVal) {
    		root = new TreeNode(root_val);
    		index++;
    		root.left = buildBSTHelper(preorder, minVal, root_val);
    		root.right = buildBSTHelper(preorder, root_val, maxVal);
    	}
    	
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
