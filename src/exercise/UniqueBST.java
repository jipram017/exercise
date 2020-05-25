package exercise;

import java.util.ArrayList;
import java.util.List;

import exercise.FlattenBinaryTree.TreeNode;

public class UniqueBST {
	
	// Time complexity O(N^2)
	// Space complexity O(N)
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; 
        
        for(int i = 1; i <= n; i++) {
        	for(int j = 0; j < i; j++) {
        		int leftSubNum = j;
        		int rightSubNum = i-1-leftSubNum;
        		dp[i] += dp[leftSubNum]*dp[rightSubNum];
        	}
        }     
        return dp[n];  
    }
    
    public static List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return generateTreesHelper(1, n);
    }
    
    public static List<TreeNode> generateTreesHelper(int m, int n){
    	List<TreeNode> result = new ArrayList<TreeNode>();
    	if(m > n) {
    		result.add(null);
    		return result;
    	}
    	for(int i = m; i <=n; i++) {
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
