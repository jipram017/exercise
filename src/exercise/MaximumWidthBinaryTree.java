package exercise;

import java.util.LinkedList;

import exercise.BalancedBST.TreeNode;

public class MaximumWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
    	if(root == null) return 0;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        int maxWidth = 0;
        root.val = 0;
        q.offer(root);
        
        while(!q.isEmpty()) {
        	int size = q.size();
        	int leftMost = 0, rightMost = 0;
        	for(int i = 0; i < size; i++) {
        		TreeNode top = q.poll();
        		if(i == 0) leftMost = top.val;
        		if(i == size - 1) rightMost = top.val;
        		if(top.left != null) {
        			top.left.val = 2 * top.val + 1;
        			q.offer(top.left);
        		}
        		if(top.right != null) {
        			top.right.val = 2 * top.val + 2;
        			q.offer(top.right);
        		}
        	}
        	maxWidth = Math.max(maxWidth, rightMost - leftMost + 1);
        }
        return maxWidth;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
