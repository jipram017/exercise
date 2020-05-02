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
		List<Integer> nodeValues = new ArrayList<Integer>();
		inOrderTraversal(nodeValues, root);
		return sortedArrayToBST(nodeValues);
	}
	
	public static TreeNode sortedArrayToBST(List<Integer> nums) {
		if(nums == null || nums.size() == 0) return null;
		int middleIdx = nums.size() / 2;
		TreeNode newNode = new TreeNode(nums.get(middleIdx));
		newNode.left = sortedArrayToBST(nums.subList(0, middleIdx));
		newNode.right = sortedArrayToBST(nums.subList(middleIdx+1, nums.size()));
		return newNode;
	}
	
	public static void inOrderTraversal(List<Integer> nodeValues, TreeNode root) {
		if(root == null) {
			return;
		}		
		inOrderTraversal(nodeValues, root.left);
		nodeValues.add(root.val);
		inOrderTraversal(nodeValues, root.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
