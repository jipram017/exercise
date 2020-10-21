package coding_preps;

import helper.DataStructure.TreeNode;

public class PathSum {
	/** LeetCode #112 **/
	// O(N) time, O(NlogN) space where N is the number of nodes
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) return false;
		return pathSumHelper1(root, sum);
	}
	
	public static boolean pathSumHelper1(TreeNode root, int sum) {
		if(root==null) return false;
		if(root.val == sum && root.left == null && root.right == null) {
			count++;
			return true;
		}
		boolean leftPath = pathSumHelper1(root.left, sum-root.val);
		boolean rightPath = pathSumHelper1(root.right, sum-root.val);
		return leftPath || rightPath;
	}
	
	static int count = 0;
	public static void pathSumHelper3(TreeNode root, int sum) {
		if(root==null) return;
		if(root.val == sum) {
			count++;
		}
		pathSumHelper3(root.left, sum-root.val);
		pathSumHelper3(root.right, sum-root.val);
	}
	
	/** LeetCode #437 **/
	// O(N) time, O(NlogN) space where N is the number of nodes
	public static int pathSum(TreeNode root, int sum) {
		if(root==null) return 0;
		pathSumHelper3(root, sum);
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
