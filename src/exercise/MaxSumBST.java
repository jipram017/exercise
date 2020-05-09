package exercise;
import exercise.FlattenBinaryTree.TreeNode;

public class MaxSumBST {
	
	public static int maxSumBST(TreeNode root) {
		int[] max = new int[1];
		maxSumBST(root, max);
		return max[0];
	}
	
	public static int[] maxSumBST(TreeNode root, int[] max) {
		if (root == null) return null;
		int[] left = maxSumBST(root.left, max);
		int[] right = maxSumBST(root.right, max);
		if(left != null && (left[1] >= root.val || left[3] == 0)){
			return new int[]{0, -1, Integer.MAX_VALUE, 0};
		}
		if(right != null && (right[2] <= root.val || right[3] == 0)){
			return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
		}
		
		int leftSum = left == null ? 0 : left[0];
		int rightSum = right == null ? 0 : right[0];
		int sum = leftSum + rightSum + root.val;
		max[0] = Math.max(max[0], sum);
		
		int maxVal = right == null ? root.val : right[2];
		int minVal = left == null ? root.val : left[1];
		return new int[] {sum, maxVal, minVal, 1};
	}
	
	public static void main(String[] args) {
		    TreeNode root = new TreeNode(5); 
		    root.left = new TreeNode(14); 
		    root.right = new TreeNode(3); 
		    root.left.left = new TreeNode(6); 
		    root.right.right = new TreeNode(7); 
		    root.left.left.left = new TreeNode(9); 
		    root.left.left.right = new TreeNode(1); 
		  
		    System.out.println( maxSumBST(root));

	}

}
