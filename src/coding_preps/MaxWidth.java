package coding_preps;

import java.util.LinkedList;
import java.util.Queue;

import helper.DataStructure.TreeNode;

/** LeetCode #662 **/
public class MaxWidth {
	
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is the number of nodes
	
	public static int widthOfBinaryTree(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int max = Integer.MIN_VALUE;
		
		root.val = 1;
		q.offer(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			max = Math.max(max, size);
			int leftMost=1, rightMost=1;
			for(int i=0; i< size; i++) {
				TreeNode top = q.poll();
				if(i==0) leftMost = top.val;
				if(i==size-1) rightMost = top.val;
				
				if(top.left != null) {
					top.left.val = 2 * top.val;
					q.offer(top.left);
				}
				if(top.right != null) {
					top.right.val = 2 * top.val + 1;
					q.offer(top.right);
				}
			}
			
			max = Math.max(rightMost-leftMost+1, max);
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
