package coding_preps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import helper.DataStructure.TreeNode;

/** LeetCode #199 **/
public class RightSideView {
	
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is the number of nodes
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null) return result;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		
		q.offer(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				TreeNode top = q.remove();
				if(i==0) result.add(top.val);
				
				if(top.right != null) {
					q.offer(top.right);
				}
				if(top.left != null) {
					q.offer(top.left);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
