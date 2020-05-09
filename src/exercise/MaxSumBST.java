package exercise;
import exercise.FlattenBinaryTree.TreeNode;

public class MaxSumBST {
	private static int max;
	public static int maxSumBST(TreeNode root) {
		maxSumBSTHelper(root);
		return max;
	}
	
	public static int[] maxSumBSTHelper(TreeNode root) {
		if (root == null) return null;
		int[] left = maxSumBSTHelper(root.left);
		int[] right = maxSumBSTHelper(root.right);
		if(left != null && (left[1] >= root.val || left[3] == 0)){
			return new int[]{0, -1, -1, 0};
		}
		if(right != null && (right[2] <= root.val || right[3] == 0)){
			return new int[]{0, -1, -1, 0};
		}
		
		int leftSum = left == null ? 0 : left[0];
		int rightSum = right == null ? 0 : right[0];
		int sum = leftSum + rightSum + root.val;
		max = Math.max(max, sum);
		
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
