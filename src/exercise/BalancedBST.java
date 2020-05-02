package exercise;

import java.util.ArrayList;
import java.util.List;

public class BalancedBST {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	}
	
	public static TreeNode balanceBST(TreeNode root) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		storeInOrder(nodes, root);
		return sortedArrayListToBST(nodes, 0, nodes.size()-1);
	}
	
	public static TreeNode sortedArrayListToBST(List<TreeNode> nums, int start, int end) {
		if(start > end) return null;
		int middleIdx = (start + end)/ 2;
		TreeNode node = nums.get(middleIdx);
		node.left = sortedArrayListToBST(nums, start, middleIdx-1);
		node.right = sortedArrayListToBST(nums, middleIdx+1, end);
		return node;
	}
	
	public static void storeInOrder(List<TreeNode> nodes, TreeNode root) {
		if(root == null) {
			return;
		}		
		storeInOrder(nodes, root.left);
		nodes.add(root);
		storeInOrder(nodes, root.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
