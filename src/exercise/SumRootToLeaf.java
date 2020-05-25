package exercise;

import exercise.FlattenBinaryTree.TreeNode;

public class SumRootToLeaf {
    public static int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 0, 0); 
    }
    
    public static int dfs(TreeNode root, int num, int sum) {
    	if(root == null) return 0;
    	num = root.val + num * 10;
    	if(root.left == null && root.right == null) return sum += num;
    	int leftSum = dfs(root.left, num, sum);
    	int rightSum = dfs(root.right, num, sum);
    	return leftSum + rightSum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
