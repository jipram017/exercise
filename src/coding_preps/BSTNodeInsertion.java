package coding_preps;

import helper.DataStructure.TreeNode;

/** LeetCode #701 **/
public class BSTNodeInsertion {
	// Time complexity O(h)
	// Space complexity O(h) where h is height of BST
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) {
        	TreeNode node = new TreeNode(val);
        	return node;
        }
        
        if(val <= root.val) {
        	root.left = insertIntoBST(root.left, val);
        }
        
        else {
        	root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
