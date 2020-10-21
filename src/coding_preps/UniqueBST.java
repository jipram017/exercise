package coding_preps;

import java.util.ArrayList;
import java.util.List;

import helper.DataStructure.TreeNode;

public class UniqueBST {
	/** LeetCode #96 **/
	// Time complexity O(n*n), space complexity O(n)
	public static int numTrees(int n) {
		if(n==0) return 1;
		int[] dp = new int[n+1];
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				int leftSubtrees = j;
				int rightSubtrees = i-1-leftSubtrees;
				dp[i] += dp[leftSubtrees]*dp[rightSubtrees];
			}
		}
		
		return dp[n];
	}
	
	/** LeetCode #95 **/
	// Time complexity O(n*n), space complexity O(nlog n)
	public static List<TreeNode> generateTrees(int n) {
		if(n==0) return new ArrayList<TreeNode>();
		return generateTreesHelper(1,n);
	}
	
	public static List<TreeNode> generateTreesHelper(int m, int n){
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(m<n) {
			result.add(null);
			return result;
		}
		
		for(int i=1; i<=n; i++) {
			List<TreeNode> leftSubtrees = generateTreesHelper(m, i-1);
			List<TreeNode> rightSubtrees = generateTreesHelper(i+1, n);
			for(TreeNode leftSubtree : leftSubtrees) {
				for(TreeNode rightSubtree : rightSubtrees) {
					TreeNode root = new TreeNode(i);
					root.left = leftSubtree;
					root.right = rightSubtree;
					result.add(root);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
