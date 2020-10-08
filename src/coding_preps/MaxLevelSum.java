package coding_preps;

import java.util.LinkedList;
import java.util.Queue;

import helper.DataStructure.TreeNode;

/** LeetCode #1161 **/
public class MaxLevelSum {
	
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is number of the nodes
	public static int maxLevelSum(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.offer(root);
		int level = 1, max = Integer.MIN_VALUE;
		int result = 1;
		
		while(!q.isEmpty()) {
			int size = q.size(),currentSum = 0;
			for(int i=0; i<size; i++) {
				TreeNode top = q.poll();
				currentSum += top.val;
				
				if(top.left != null) q.offer(top.left);
				if(top.right != null) q.offer(top.right);
			}
			
			if(currentSum > max) {
				max = currentSum; result = level;
			}
			
			level++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
