package exercise;
import exercise.FlattenBinaryTree.TreeNode;


// Works only for positive values
public class MaxSumBST {
	public static class BinaryTree{
		int min;
		int max;
		boolean isBST;
		int sum;
		int currentMax;
		
		public BinaryTree() {};
		public BinaryTree(int min, int max, boolean isBST, int sum, int currentMax) {
			this.min = min;
			this.max = max;
			this.isBST = isBST;
			this.sum = sum;
			this.currentMax = currentMax;
		}
	}
	
	public static int cmax = Integer.MIN_VALUE;
	public static int maxSumBST(TreeNode root) {
	    return maxSumBSTHelper(root).currentMax;
	}
	
	public static BinaryTree maxSumBSTHelper(TreeNode root) {
		if(root == null) {
			return new BinaryTree(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0, 0);
		}
        
        if(root.left == null && root.right == null) {
			cmax = Math.max(cmax, root.val);
			return new BinaryTree(root.val, root.val, true, root.val, cmax);
		}
		
		BinaryTree leftSubtree = maxSumBSTHelper(root.left);
		BinaryTree rightSubtree = maxSumBSTHelper(root.right);

		BinaryTree curTree = new BinaryTree();
		if(leftSubtree.max < root.val && rightSubtree.min > root.val &&
		   leftSubtree.isBST && rightSubtree.isBST) {
		    curTree.min = Math.min(root.val, Math.min(leftSubtree.min, rightSubtree.min));
			curTree.max = Math.max(root.val, Math.max(leftSubtree.max, rightSubtree.max));
			curTree.isBST = true;
			cmax = Math.max(cmax, leftSubtree.sum + rightSubtree.sum + root.val);
			curTree.sum = leftSubtree.sum + rightSubtree.sum + root.val;
            curTree.currentMax = cmax;
			return curTree;
		}
		
		curTree.isBST = false;
		curTree.currentMax = cmax;
		curTree.sum = root.val + leftSubtree.sum + rightSubtree.sum;
		return curTree;
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
