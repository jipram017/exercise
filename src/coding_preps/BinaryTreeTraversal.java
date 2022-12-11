package coding_preps;

import java.util.ArrayList;
import java.util.List;

import exercise.FlattenBinaryTree;
import helper.DataStructure.TreeNode;

public class BinaryTreeTraversal {
	// Time complexity O(N)
	// Space complexity O(NlogN)
	// where N is total number of nodes
	public static List<Integer> result = new ArrayList<Integer>();
	public static List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	/** LeetCode #94 **/
	public static List<Integer> inorderTraversal(TreeNode root) {
		if(root==null) return result;
		inorderTraversal(root.left);
		result.add(root.val);
		inorderTraversal(root.right);
		return result;
	}
	
	/** LeetCode #144 **/
	public static List<Integer> preorderTraversal(TreeNode root) {
		if(root==null) return result;
		result.add(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		return result;
	}
	
	/** LeetCode #145 **/
	public static List<Integer> postorderTraversal(TreeNode root) {
		if(root==null) return result;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		result.add(root.val);
		return result;
	}
	
	/** LeetCode #102 **/
	public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return res;
		levelOrder(root, 0);
		return res;
	}
	
	public static void levelOrder(TreeNode root, int level) {
        if(root==null) return;
		if(level == res.size()) {
			res.add(new ArrayList<Integer>());
		}
		
		res.get(level).add(root.val);
		levelOrder(root.left, level+1);
		levelOrder(root.right, level+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
