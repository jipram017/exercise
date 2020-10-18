package coding_preps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import helper.DataStructure.TreeNode;

/** LeetCode 103 **/
public class ZigzagLevelOrderTraversal {
	// Time complexity O(N)
	// Space complexity O(N) 
	// where N is the number of nodes
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null) return result;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		
		boolean zigzag = false;
		q.offer(root);
		
		while(!q.isEmpty()) {
			List<Integer> rs = new ArrayList<Integer>();
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				TreeNode top = q.poll();
				if(zigzag) {
					rs.add(0, top.val);
				} else {
					rs.add(top.val);
				}
				
				if(top.left != null) {
					q.offer(top.left);
				}
				if(top.right != null) {
					q.offer(top.right);
				}
			}
			
			zigzag = !zigzag;
			result.add(rs);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
