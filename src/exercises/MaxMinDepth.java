package exercises;

import helper.DataStructure.TreeNode;

public class MaxMinDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(1+maxDepth(root.left), 1+maxDepth(root.right));
    }
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return 1+minDepth(root.right);
        if(root.right == null) return 1+minDepth(root.left);
        return Math.min(1+minDepth(root.left), 1+minDepth(root.right));        
    }
}
